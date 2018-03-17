package com.dqsy.spring.jdbctemplate.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dqsy.spring.jdbctemplate.dao.IUserDao;
import com.dqsy.spring.jdbctemplate.entity.User;
import com.dqsy.spring.jdbctemplate.service.IUserService;

public class JDBCtest {
	private ApplicationContext ctx;
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void addUserTest(){
		User user = new User();
		user.setName("王金超");
		user.setAccount(new BigDecimal(12000));
		IUserDao userDao = (IUserDao) ctx.getBean("userDao");
		System.out.println(userDao.addUser(user));
	}
	@Test
	public void addUser1Test(){
		User user = new User();
		user.setName("何冰");
		user.setAccount(new BigDecimal(8000));
		IUserService userDao = (IUserService) ctx.getBean("userService");
		System.out.println(userDao.addUser(user));
	}
	@Test
	public void updateUserTest(){
		User user = new User();
		user.setId(1);
		user.setName("阮宁宁");
		user.setAccount(new BigDecimal(500));
		IUserService userService = (IUserService) ctx.getBean("userService");
		System.out.println(userService.updateUser(user));
	}
	@Test
	public void deleteUserTest(){
		int id=5;
		IUserService userService = (IUserService) ctx.getBean("userService");
		System.out.println(userService.deleteUser(id));
	}
	@Test
	public void serchUserTest(){
		IUserService userService = (IUserService) ctx.getBean("userService");
		List<User> users = userService.getUserList();
		for(User user : users){
				System.out.println(user);
			}
		
		}
}
