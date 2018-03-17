package com.dqsy.spring.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dqsy.spring.dao.IUserDao;

public class AspectJXmlRText {
	private ApplicationContext ctx=null;
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("applicationContext-aspect.xml");
	}
	//前置通知
	@Test
	public void aspectJText(){
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
