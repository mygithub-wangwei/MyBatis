package com.dqsy.spring.advice;

import org.springframework.aop.ThrowsAdvice;

public class MyThrowingAdvice implements ThrowsAdvice {
	public void afterThrowing(Exception e){
		System.out.println("发生异常"+e.toString());
	}
}
