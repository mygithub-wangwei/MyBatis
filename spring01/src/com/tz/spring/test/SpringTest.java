package com.tz.spring.test;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.tz.spring.beans.HelloWorldImpl;
import com.tz.spring.beans.IHelloWorld;

public class SpringTest {
	/**
	 * 以前的做法
	 */
	 @Test
	 public void oldMethod(){
		 //创建一个对象
		 IHelloWorld hello = new HelloWorldImpl();
		 //调用hello方法
		 //手更赋值
		 hello.setUserName("spring");
		 hello.hello();
	 }
	 /**
	  * spring事列
	  * ClassPathXmlApplicationContext   beans的相对路径
	  */
	 @Test
	 public void springMethod(){
		 //1.创建spring容器
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		 //2.从容器中获取吧bean对象
		 IHelloWorld HelloWorld = (IHelloWorld) ctx.getBean("helloWorld");
		 //3.调用方法
		 HelloWorld.hello();
	 }
	 /**
	  * spring BeanFactory
	  */
	 @Test
	 public void beanFctoryMethod(){
		 //注意-中间的横线是表示已经弃用的
		 XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml")); 
		 IHelloWorld helloWorld = (IHelloWorld) factory.getBean("helloWorld");
		 helloWorld.hello();
		 
	 }
	 /**
	  * spring FileSystemXmlApplicationContext
	  * D:\Program Files\workplace\spring01\src  绝对路径
	  */
	 @Test
	 public void FileSystemXmlApplicationContextMethod(){
		//1.创建spring容器
		 ApplicationContext ctx = new FileSystemXmlApplicationContext
				 ("D:/Program Files/workplace/spring01/src/beans.xml");
		 //2.从容器中获取吧bean对象
		 IHelloWorld HelloWorld = (IHelloWorld) ctx.getBean("helloWorld");
		 //3.调用方法
		 HelloWorld.hello();
		 
	 }
}
