package com.dqsy.spring.test;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dqsy.spring.service.IUserService;

public class AccountAnnotationTest {
	private ApplicationContext ctx = null;
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("applicationContext-annotation.xml");
	}
	@Test
	public void test(){
		IUserService userService = (IUserService) ctx.getBean("userService");
		userService.operateMulAccount(10,11, new BigDecimal(100));
	}
	
}