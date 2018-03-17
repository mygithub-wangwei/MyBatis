package com.dqsy.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dqsy.spring.bean.Gather;
import com.dqsy.spring.bean.GatherOther;

public class GatherTest {
	/**
	 * 集合属性的注入
	 */
	@Test
	public void gatherTest(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-property.xml");
		Gather ga = (Gather) ctx.getBean("gather");
		System.out.println("string :"+ga.getStrVal());
		System.out.println("int :"+ga.getIntVal());
		System.out.println("list :"+ga.getListVal());
		System.out.println("set :"+ga.getSetVal());
		System.out.println("map :"+ga.getMapVal());
		
	}
	/**
	 *懒加载的测试
	 */
	@Test
	public void gatherOtherTest(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-property.xml");
		GatherOther ga = (GatherOther) ctx.getBean("gatherother");
		System.out.println(ga);
		
		
	}
}
