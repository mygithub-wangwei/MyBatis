package com.dqsy.spring.test;

import java.sql.Driver;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dqsy.spring.dao.Impl.FoodCarDaoImpl;
import com.dqsy.spring.dao.Impl.LuHuCarDaoImpl;
import com.dqsy.spring.service.Impl.HelloService;
import com.dqsy.spring.service.Impl.HiService;
import com.dqsy.spring.service.Impl.UserServiceImpl;

public class SpringText {
	/**
	 * 一个属性set方法注入
	 */
	@Test
	public void setTest(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloService hello = (HelloService) ctx.getBean("hello");
		hello.say();
	}
	/**
	 * 多个属性set方法注入
	 */
	@Test
	public void set1Test(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		FoodCarDaoImpl foodCar = (FoodCarDaoImpl) ctx.getBean("foodCar");
		System.out.println(foodCar.run());
	}
	/**
	 * 构造函数方法注入
	 */
	@Test
	public void constructorTest(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HiService hello = (HiService) ctx.getBean("hi");
		hello.say();
	}
	/**
	 * 多个参数的构造函数方法注入
	 */
	@Test
	public void constructor1Test(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		LuHuCarDaoImpl luhu = (LuHuCarDaoImpl) ctx.getBean("luhuCar");
		System.out.println(luhu.run());
	}
	/**
	 * 利用ref属性内部注入bean
	 */
	@Test
	public void setrefTest(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServiceImpl user = (UserServiceImpl) ctx.getBean("user");
		user.drive();
	}
	/**
	 * 另一种写法util标签
	 */
	@Test
	public void utilfTest(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServiceImpl user1 = (UserServiceImpl) ctx.getBean("user1");
		user1.drive();
	}
	/**
	 * 简化写法
	 */
	@Test
	public void pfTest(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServiceImpl user2 = (UserServiceImpl) ctx.getBean("user2");
		user2.drive();
	}
	
}
