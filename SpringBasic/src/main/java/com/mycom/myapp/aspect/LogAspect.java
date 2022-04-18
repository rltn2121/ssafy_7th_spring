package com.mycom.myapp.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component	// Component Scan의 대상이 되도록 만듦
@Aspect		// aspectj의 대상이 되도록 만듦
public class LogAspect {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 모든 리턴 타입에 대해서 com.mycom.myapp.aspect.모든 클래스(모든 파라미터)
	@Pointcut(value = "execution(* com.mycom.myapp.aspect.*.*(..))")
	private void logPointcut() {}
	
	
	@After("logPointcut()")
	public void beforeLog(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("메소드 이름: " + signature.getName());	// logger를 이용하지 않는 단순 출력
		logger.debug("[Logger Before] " + signature.getName());	// logger를 이용한 출력
	}
	
	
	// 모든 리턴 타입에 대해서 com.mycom.myapp.aspect.모든 클래스(모든 파라미터)
	@Pointcut(value = "execution(* com.mycom.myapp.aspect.*.*(int, String, int))")
	private void logPointcut2() {}
	
	@After("logPointcut2()")
	public void beforeLog2(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("메소드 이름: " + signature.getName());	// logger를 이용하지 않는 단순 출력
		logger.debug("[Logger Before2] " + signature.getName());	// logger를 이용한 출력
	}
}
