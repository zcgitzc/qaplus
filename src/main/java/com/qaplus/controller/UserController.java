package com.qaplus.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qaplus.annotation.SystemOperatorLog;
import com.qaplus.constant.BaseVoid;
import com.qaplus.constant.Common;
import com.qaplus.constant.ErrorCode;
import com.qaplus.entity.QaUser;
import com.qaplus.entity.vo.ClassStuZTreeVo;
import com.qaplus.entity.vo.Page;
import com.qaplus.entity.vo.ResponseData;
import com.qaplus.entity.vo.UserVo;
import com.qaplus.service.UserService;
import com.qaplus.utils.CookieUtil;
import com.qaplus.utils.EncryptUtil;

@Controller
@RequestMapping("user")
@ResponseBody
public class UserController extends SuperController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Resource
	private UserService userService;
	private static final String DELIMITER = ":";
	private static final int MAXAGE = 3600 * 60 * 24 * 7;

	@SystemOperatorLog(description = "用户登录")
	@RequestMapping("user_login")
	public List<String> userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) {
		String pwd = new String(EncryptUtil.encrypt(password));
		QaUser user = userService.userLogin(username, pwd);
		if (user == null) {
			throw new RuntimeException("登录失败，请检查你的用户名密码是否正确");
		} else {
			// TODO 这里要对存在cookice的信息加密
			CookieUtil.setCookie(request, response, Common.LOGIN_COOKIE.getValue(), username + DELIMITER + new String(EncryptUtil.encrypt(password)), MAXAGE);
			logger.info(String.format("用户登录成功:%s", username));
			request.getSession().setAttribute(Common.CURRENT_OPERATOR.getValue(), user);
			// TODO 验证它必须是一个地址
			String requestUri = (String) request.getSession().getAttribute("requestUri");
			return Arrays.asList(StringUtils.isNotEmpty(requestUri) ? requestUri : "");
		}
	}

	@RequestMapping("user_reg")
	public QaUser userRegister(UserVo user) {
		return userService.userRegister(user);
	}

	@RequestMapping("queryAllUser")
	public ResponseData<QaUser> queryAllUser(Page page, String searchKey) {
		return userService.queryAllUser(page, searchKey);
	}

	@RequestMapping("select_all_tea")
	public List<QaUser> selectAllTeacher() {
		return userService.queryAllTeachers();
	}

	@RequestMapping("build_class_stu_tree")
	public List<ClassStuZTreeVo> buildClassStuZTree(HttpServletRequest request) {
		return userService.buildMyClassStuZTree();
	}

	@RequestMapping("check_username")
	public ResponseData<QaUser> checkUsername(String username) {
		try {
			QaUser user = userService.queryByUsername(username);
			ErrorCode errorCode = user == null ? ErrorCode.USERNAME_VALIDATE : ErrorCode.USERNAME_EXIST;
			return new ResponseData<QaUser>(errorCode, errorCode.getDesc(), null, false);
		} catch (Exception e) {
			logger.error("出错了", e);
			return new ResponseData<QaUser>(ErrorCode.FAUILURE, ErrorCode.FAUILURE.getDesc(), null, true);
		}
	}

	@RequestMapping("preview_img")
	public void previewImg(HttpServletResponse response) throws Exception {
		userService.previewImg(response);
	}

	@RequestMapping("update_my_info")
	public BaseVoid updateMyInfo(QaUser user, HttpServletRequest request) {
		// 修改用户信息之后，及时跟新session中的用户信息
		userService.updateUserInfo(user);
		return new BaseVoid();
	}

	@RequestMapping("logout")
	public BaseVoid logout(HttpServletRequest request, HttpServletResponse response) {
		CookieUtil.deleteCookie(request, response, Common.LOGIN_COOKIE.getValue());
		request.getSession().invalidate();
		return new BaseVoid();
	}

	@RequestMapping("queryAllStusByLike")
	public List<UserVo> queryAllStusByLike(Long teacherId, String searchKey) {
		return userService.queryAllStusByLike(Arrays.asList(teacherId), searchKey);
	}
}