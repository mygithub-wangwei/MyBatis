package com.dqsy.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dqsy.spring.autowire.Person;

public class AutoworeTest {
	@Test
	public void autoWireTest(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
	}
}
