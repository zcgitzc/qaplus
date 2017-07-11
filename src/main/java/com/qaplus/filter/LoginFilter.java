package com.qaplus.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.qaplus.constant.Common;
import com.qaplus.entity.QaUser;
import com.qaplus.entity.vo.UserVo;
import com.qaplus.service.UserService;
import com.qaplus.utils.CookieUtil;

public class LoginFilter implements Filter {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginFilter.class);

	private String notDealResources;
	private UserService userService;

	private static final String TO_LOGIN = "/qaplus/user/login/login.jsp";
	private static final String DO_LOGIN = "/qaplus/user/user_login.json";
	private static final String TO_HOME = "/qaplus/user/home/home.jsp";
	// 注册的时候需要，所以不要拦截
	private static final String SELECT_ALL_CLASS = "/qaplus/class/select_all_class.json";
	private static final String GET_PHONE_SUPPLIER = "/qaplus/common/get_phone_supplier.json";
	private static final String USER_REGISTER = "/qaplus/user/user_reg.json";
	private static final String CHECK_USERNAME = "/qaplus/user/check_username.json";

	private static final String DELIMITER = ":";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 得到bean
		// implements ApplicationContextAware实现这个接口貌似也可以获取到applicationContext对象
		ApplicationContext appC = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
		userService = (UserService) appC.getBean("userServiceImpl");
		notDealResources = filterConfig.getInitParameter("notDealResources");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String uri = request.getRequestURI();
		int i = 0;

		String[] uris = notDealResources.split(",");
		for (String notDealUri : uris) {
			if (uri.endsWith(notDealUri)) {
				i++;
			}
		}
		if (i != 0) {
			chain.doFilter(req, res);
			return;
		}
		logger.info(String.format("LoginFilter拦截的uri:%s", uri));
		QaUser user = (QaUser) request.getSession().getAttribute(
				Common.CURRENT_OPERATOR.getValue());

		if (null != user) {
			if (uri.equals(TO_LOGIN)) {
				response.sendRedirect(TO_HOME);
			} else {
				chain.doFilter(req, res);
			}

		} else {
			String cookieValue = CookieUtil.getCookieValue(request,
					Common.LOGIN_COOKIE.getValue());
			logger.info(String.format("获取到的Cookie值为：%s", cookieValue));

			if (StringUtils.isEmpty(cookieValue)) {
				if (uri.equals(TO_LOGIN) || uri.equals(DO_LOGIN)
						|| uri.equals(SELECT_ALL_CLASS)
						|| uri.equals(USER_REGISTER)
						|| uri.equals(GET_PHONE_SUPPLIER)
						|| uri.equals(CHECK_USERNAME)) {
					chain.doFilter(req, res);
				} else {
					request.getSession().setAttribute("requestUri", uri);
					response.sendRedirect(TO_LOGIN);
				}
			} else {
				String[] msg = cookieValue.split(DELIMITER);
				String username = "";
				String password = "";

				try {
					username = msg[0];
					password = msg[1];
				} catch (Exception e) {
					response.sendRedirect(TO_LOGIN);
				}
				UserVo u = userService.userLogin(username, password);
				if (null != u) {
					request.getSession().setAttribute(
							Common.CURRENT_OPERATOR.getValue(), u);

					if (uri.equals(TO_LOGIN)) {
						response.sendRedirect(TO_HOME);
					} else {
						chain.doFilter(req, res);
					}
				} else {
					request.getSession().setAttribute("requestUri", uri);
					response.sendRedirect(TO_LOGIN);
				}
			}
		}
	}

	@Override
	public void destroy() {

	}

}
