package com.darren;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.asm.commons.Method;

public class BeforeAdvisor implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("additional concern before actual logic");
	}

}
