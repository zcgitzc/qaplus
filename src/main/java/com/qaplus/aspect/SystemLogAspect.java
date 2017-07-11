package com.qaplus.aspect;

import java.lang.reflect.Method;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.qaplus.annotation.SystemErrorLog;
import com.qaplus.annotation.SystemOperatorLog;
import com.qaplus.constant.Common;
import com.qaplus.constant.CommonBoolean;
import com.qaplus.entity.QaLog;
import com.qaplus.entity.QaUser;
import com.qaplus.service.LogService;
import com.qaplus.utils.RequestUtil;

/**
 * 切点类
 */
@Aspect
@Component
public class SystemLogAspect{
	private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);
	// 注入Service用于把日志保存数据库
	@Resource
	private LogService logService;

	// Service层切点
	@Pointcut("@annotation(com.qaplus.annotation.SystemOperatorLog)")
	public void operatorAspect() {
	}

	// Controller层切点
	@Pointcut("@annotation(com.qaplus.annotation.SystemErrorLog)")
	public void errorAspect() {
	}

	/**
	 * 后置通知 用于拦截Controller层记录用户的操作
	 * @param joinPoint
	 *            切点
	 */
	@After("operatorAspect()")
	public void doAfter(JoinPoint joinPoint) {
		insertLog(CommonBoolean.Y, joinPoint, null);
	}

	private void insertLog(CommonBoolean commonBoolean,JoinPoint joinPoint,Throwable ex){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		QaUser user = (QaUser) session.getAttribute(Common.CURRENT_OPERATOR
				.getValue());
		
		String ip =RequestUtil.getRemoteAddr(request);
		String methodName=joinPoint.getTarget().getClass().getName() + "."
				+ joinPoint.getSignature().getName() + "()";
		String methodDesc="";
		try {
			methodDesc = getOperatorMethodDescription(joinPoint);
		} catch (Exception e) {
			logger.error("记录日志时：获取methodDesc失败", e);
		}
		String params="";
		if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {  
            params +=JSON.toJSONString(joinPoint.getArgs()[0]);  
        }
		QaLog log = new QaLog();
		//异常
		log.setIsSuccess(commonBoolean.equals(CommonBoolean.Y)?CommonBoolean.Y.name():CommonBoolean.N.name());
		
		if(null!=ex){
			log.setErrorMsg(ex.getMessage());
			log.setErrorTip(ex.getClass().getName());
		}
		
		log.setIp(ip);
		log.setMethodDesc(methodDesc);
		log.setMethodName(methodName);
		log.setParams(params);
		if(null==user){
			log.setRecUpdateUser("Session取不到员工信息-正在登录");
		}else{
			log.setRecUpdateUser(user.getName());
		}
		logService.insertLog(log);
	}
	
	/**
	 * 异常通知 用于拦截service层记录异常日志
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(pointcut = "errorAspect()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
		insertLog(CommonBoolean.N, joinPoint, e);
	}

	/**
	 * 获取注解中对方法的描述信息 用于service层注解
	 * 
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */
	public static String getErrorMethodDescription(JoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		@SuppressWarnings("rawtypes")
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				@SuppressWarnings("rawtypes")
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(SystemErrorLog.class)
							.description();
					break;
				}
			}
		}
		return description;
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 * 
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */
	public static String getOperatorMethodDescription(JoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		@SuppressWarnings("rawtypes")
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				@SuppressWarnings("rawtypes")
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(
							SystemOperatorLog.class).description();
					break;
				}
			}
		}
		return description;
	}
}