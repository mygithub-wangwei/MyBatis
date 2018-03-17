package com.dqsy.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dqsy.spring.bean.HelloChina;
import com.dqsy.spring.bean.HelloWorld;
import com.dqsy.spring.bean.InitBean;
import com.dqsy.spring.bean.ScopeBean;
import com.dqsy.spring.bean.User;

public class BeanText {
	
	/**
	 * 什么是bean
	 */
	@Test
	public void Text(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		User user = (User) ctx.getBean("user");
		user.setName("兰州好美");
		System.out.println(user);
		user.addUser();
	}
	/**
	 * bean的初始化
	 */
	@Test
	public void TextInit(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		InitBean init = (InitBean) ctx.getBean("init");
		System.out.println(init);
	}
	/**
	 * scope的作用域
	 */
	@Test
	public void TextScope(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ScopeBean scope = (ScopeBean) ctx.getBean("scope");
		System.out.println("scope :"+scope);
		
		ScopeBean scope1 = (ScopeBean) ctx.getBean("scope");
		System.out.println("scope1:"+scope1);
	}
	/**
	 * spring bean的继承关系
	 */
	@Test
	public void TextParent(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorld hello = (HelloWorld) ctx.getBean("hello");
		System.out.println("hello.getName() :"+hello.getName());
		HelloChina china = (HelloChina) ctx.getBean("china");
		System.out.println("china.getName() :"+china.getName());
		System.out.println("china.Age() :"+china.getAge());
	
	}
}
