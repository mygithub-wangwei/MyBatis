package com.dqsy.spring.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MyAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object retuenValue, Method paramMethod, Object[] paramArrayObject, Object targert) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("后置通知...在方法执行后运行");

	}

}
