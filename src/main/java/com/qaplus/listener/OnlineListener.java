package com.qaplus.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.qaplus.constant.Common;
import com.qaplus.entity.QaUser;

/**
 * ServletContextListener application 监听 HttpSessionListener session创建销毁 监听
 * HttpSessionAttributeListener session属性添加、移除、替换 监听
 * 
 * @author wb-zc189961
 *
 */
public class OnlineListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
	// 声明一个ServletContext对象
	private ServletContext application = null;

	/**
	 * 给session赋值时触发
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// 如果登陆成功，则将用户名保存在列表之中
		Set<QaUser> allOnlineUser = (Set<QaUser>) this.application.getAttribute("allOnlineUser");
		if (se.getValue() instanceof QaUser) {
			allOnlineUser.add((QaUser) se.getValue());
		}
		this.application.setAttribute("allOnlineUser", allOnlineUser);
	}

	/**
	 * 移除session值时触发
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		refreshCurrUser(se.getSession());
	}

	/**
	 * 替换session值时触发
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
	}

	/**
	 * session创建时触发
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
	}

	/**
	 * session销毁时被触发
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		refreshCurrUser(se.getSession());
	}

	/**
	 * 服务器启动
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 容器初始化时，向application中存放一个空的容器
		this.application = sce.getServletContext();
		this.application.setAttribute("allOnlineUser", new HashSet<QaUser>());

	}

	/**
	 * 服务器销毁
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	private void refreshCurrUser(HttpSession session) {
		// 将用户名称从列表中删除
		Set<QaUser> allOnlineUser = (Set<QaUser>) this.application.getAttribute("allOnlineUser");
		QaUser user;
		try {
			user = (QaUser) session.getAttribute(Common.CURRENT_OPERATOR.getValue());
			allOnlineUser.remove(user);
			this.application.setAttribute("allOnlineUser", allOnlineUser);
		} catch (Exception e) {

		}
	}

}
