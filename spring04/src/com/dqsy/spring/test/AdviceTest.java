package com.dqsy.spring.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dqsy.spring.proxy.IUserDao;

public class AdviceTest {
	private ApplicationContext ctx=null;
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	//前置通知
	@Test
	public void beforText(){
		IUserDao userDao = (IUserDao) ctx.getBean("myBeforeProxy");//代理对象
		userDao.addUser();
		
	}
	//后置通知
	@Test
	public void afterText(){
		IUserDao userDao = (IUserDao) ctx.getBean("myAfterProxy");//代理对象
		userDao.addUser();
		
	}
	//后置通知
	@Test
	public void aroundText(){
		IUserDao userDao = (IUserDao) ctx.getBean("myAroundProxy");//代理对象
		userDao.addUser();
		
	}
	//异常通知
	@Test
	public void throwText(){
		IUserDao userDao = (IUserDao) ctx.getBean("myAroundProxy");//代理对象
		userDao.addUser();
		
	}
}
