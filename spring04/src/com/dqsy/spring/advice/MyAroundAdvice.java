package com.dqsy.spring.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("环绕通知...在方法前执行");
		Object result = invocation.proceed();
		System.out.println("环绕通知...在方法后执行");
		result = false;
		return result;
	}

}
