package com.dqsy.spring.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dqsy.spring.proxy.IPersonDao;
import com.dqsy.spring.proxy.IUserDao;

public class AdvisorTest {
	private ApplicationContext ctx = null;
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("applicationContext-auto.xml");
	}
	/**
	 * 前置通知的切入点顾问
	 */
	//@Ignore
	@Test
	public void beforTest(){
		IUserDao userDao = (IUserDao) ctx.getBean("userDao");
		userDao.addUser();
		userDao.serchUser();
		System.out.println("------------------------------------");
		IPersonDao userDao1 = (IPersonDao) ctx.getBean("personDao");
		userDao1.addStudent();
		userDao1.modify();
		
		
	}
	/**
	 * 后置通知的切入点顾问
	 */
	//@Ignore
	@Test
	public void afterTest(){
		IUserDao userDao = (IUserDao) ctx.getBean("myAfterAdvisorProxy");
		userDao.addUser();
		userDao.serchUser();
	}
}
