package com.myedu.myapp.hello.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LogAspect {
	
	@Pointcut(value="execution(* com.myedu..*.sayHello(..))")
	private void helloPointcut() {}
	
	@Pointcut(value="execution(* com.myedu..*.sayBye(..))")
	private void byePointcut() {}
	
	@Before("helloPointcut()")
	public void beforeLog(JoinPoint joinPoint) {
		Signature s = joinPoint.getSignature();
		System.out.printf("[LOG] : Before method name : %8s\n",s.getName());
	}
	
	@After("helloPointcut()")
	public void afterLog(JoinPoint joinPoint) {
		Signature s = joinPoint.getSignature();
		System.out.println("[LOG] : Before method name : "+ s.getName());
	}
	
	@Around("execution(* com.myedu..*.*(..))")
	public static Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Signature s = joinPoint.getSignature();
		String methodName = s.getName();
		System.out.printf("[LOG] : Before method name : %8s, time check start\n",methodName);
	
		long start = System.nanoTime();
		
		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch (Exception e) {
			System.out.println("[LOG] : Exception in " + methodName);
		} finally {
			System.out.println("[LOG] : Finally in " + methodName);
		}
		
		long end = System.nanoTime();
		System.out.printf("[LOG] : After  method name : %8s, time check end\n",methodName);
		System.out.println("[LOG] : "+methodName+" Processing time is "+(end-start)+"ns");
	
		return result;
	}
}
