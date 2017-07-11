package com.qaplus.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切点类
 */
@Aspect
@Component
public class WrapControllerDataAspect {

	@Pointcut("execution(* com.qaplus.controller..*.*(..))")
	public void resultMapAspect() {
	}

	@AfterReturning(value = "resultMapAspect()", returning = "resultMap")
	public void abc(JoinPoint joinpoint, Object resultMap) throws Throwable {
		System.out.println("看一下数据");
	}

}