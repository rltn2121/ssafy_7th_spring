package com.mycom.myboard.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); // log4j.xml 과 연계
	
	@Pointcut(value="execution(* com.mycom.myboard..*(..))")
	private void logPointcut(){}

	
	@Before("logPointcut()")
	public void beforeLog(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		logger.debug("[Loger: Before] 메서드 이름 : " + signature.getName()); // 이 메세지를 debug level 로 출력한다는 의미
	}
	
	@After("logPointcut()")
	public void afterLog(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		logger.info("[Loger: After] 메서드 이름 : " + signature.getName()); // 이 메세지를 info level 로 출력한다는 의미
	}
}
