package com.darren;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackOperation {

	@Pointcut("execution(* Operation.*(..))")
	public void before() { // pointcut name

	}

	@Pointcut("execution(* Operation.*(..))")
	public void after() { // pointcut name

	}

	@Pointcut("execution(* Operation.k(..))")
	public void around() { // pointcut name

	}


	@Before("before()") // applying pointcut on before advice
	public void beforeAdvice(JoinPoint jp) { // it is advice (before advice)
		// System.err.println("beforeAdvice is invoked");
	}

	@After("after()")
	public void afterAdvice(JoinPoint jp) {
		// System.err.println("afterAdvice is invoked");
	}

	@AfterReturning(pointcut = "execution(* Operation.*(..))", //
	    returning = "result")
	public void afterReturningAdvice(JoinPoint jp, Object result) {
		// System.err.println("afterReturning is invoked");
		// System.out.println("Method Signature: " + jp.getSignature());
		// System.out.println("Result in advice: " + result);
		// System.out.println("end of after returning advice...");
	}

	@Around("around()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
//		System.err.println("Additional concern Before k()");
		Object obj = pjp.proceed();
//		System.err.println("Additional concern After k()");
		return obj;
	}

	@AfterThrowing(pointcut = "execution(* Operation.*(..))", throwing = "error")
	public void afterThrowing(JoinPoint jp, Throwable error) {
		System.out.println("additional concern");
		System.out.println("method Singature: " + jp.getSignature());
		System.out.println("Exception is " + error);
		System.out.println("end of after throwing advice...");
	}

}
