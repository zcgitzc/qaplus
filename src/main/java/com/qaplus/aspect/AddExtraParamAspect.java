package com.qaplus.aspect;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.transaction.annotation.Transactional;

import com.qaplus.entity.QaUser;
import com.qaplus.service.UserService;

public class AddExtraParamAspect {
	@Resource
	private UserService userService;

	private static final String CREATOR = "recCreateUser";
	private static final String MODIFIER = "recUpdateUser";
	private static final String GMTCREATE = "recCreateDate";
	private static final String GMTMODIFIED = "recUpdateDate";

	public void beforeInsert(JoinPoint jp) {
		Object[] args = jp.getArgs();

		if (args != null && args.length > 0) {
			Object argument = args[0];
			BeanWrapper beanWrapper = new BeanWrapperImpl(argument);
			// 设置创建时间和修改时间
			if (beanWrapper.isWritableProperty(GMTCREATE)) {
				beanWrapper.setPropertyValue(GMTCREATE, new Date());
			}
			if (beanWrapper.isWritableProperty(GMTMODIFIED)) {
				beanWrapper.setPropertyValue(GMTMODIFIED, new Date());
			}
			// 设置创建人和修改人
			if (beanWrapper.isWritableProperty(CREATOR)) {
				beanWrapper.setPropertyValue(CREATOR, getCurrUsername());
			}
			if (beanWrapper.isWritableProperty(MODIFIER)) {
				beanWrapper.setPropertyValue(MODIFIER, getCurrUsername());
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void beforeUpdate(JoinPoint jp) {
		Object[] args = jp.getArgs();
		// myBatis只能传递一个参数
		if (args != null && args.length > 0) {
			Object argument = args[0];

			// 如果argument是map类型
			if (argument instanceof Map) {
				Map map = (Map) argument;
				map.put(GMTMODIFIED, new Date());
				map.put(MODIFIER, getCurrUsername());
			} else {
				BeanWrapper beanWrapper = new BeanWrapperImpl(argument);
				if (beanWrapper.isWritableProperty(GMTMODIFIED)) {
					beanWrapper.setPropertyValue(GMTMODIFIED, new Date());
				}
				if (beanWrapper.isWritableProperty(MODIFIER)) {
					beanWrapper.setPropertyValue(MODIFIER, getCurrUsername());
				}
			}
		}
	}

	private String getCurrUsername() {
		QaUser user;
		try {
			user = userService.getCurrUserBySession();
			return user.getUsername();
		} catch (Exception e) {
			return "system";
		}
	}
}
