package com.spring.springWeb.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
public static final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
@Pointcut("execution(* com.spring.springWeb.*.*.*(..))")
	private void generalPointCut() {
		
	}
	@Before("generalPointCut()")
	public void infoLog(JoinPoint joinPoint) {
		logger.info(joinPoint.getTarget().getClass().getSimpleName()+ " "+ joinPoint.getSignature().getName());
		//System.out.println(joinPoint.getTarget().getClass().getSimpleName()+ " "+ joinPoint.getSignature().getName());
	}

}
