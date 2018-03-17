package com.dqsy.spring.test;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dqsy.spring.service.IUserService;

public class AccountNoTransTest {
	private ApplicationContext ctx = null;
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void test(){
		IUserService userService = (IUserService) ctx.getBean("userService");
		userService.operateAccount(9,10, new BigDecimal(100));
		userService.operateAccount(9,10, new BigDecimal(100));
	}
	
}