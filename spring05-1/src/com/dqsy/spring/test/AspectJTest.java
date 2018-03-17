package com.dqsy.spring.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dqsy.spring.dao.IUserDao;

public class AspectJTest {
	private ApplicationContext ctx=null;
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void aspectJTest(){
		IUserDao userDao = (IUserDao) ctx.getBean("userDao");
		userDao.addUser();
		System.out.println();
		userDao.getUser();
		System.out.println();
		userDao.updateUser();
		System.out.println();
		userDao.deleteUser();
	}
}
