package com.myedu.myapp.hello.app;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class PerformanceLog {

	public static Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Signature s = joinPoint.getSignature();
		String methodName = s.getName();
		System.out.println("[LOG] : Before method name : "+methodName+" time check start");
	
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
		System.out.println("[LOG] : After method name : "+methodName+" time check end");
		System.out.println("[LOG] : "+methodName+" Processing time is "+(end-start)+"ns");
	
		return result;
	}
}
