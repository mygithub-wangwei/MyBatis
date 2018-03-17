package com.dqsy.spring.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.dqsy.spring.proxy.IUserDao;
import com.dqsy.spring.proxy.impl.IUserDaoImpl;

public class AopTest {
	/**
	 * 常规的调用
	 */
	@Test
	public void test(){
		IUserDao userDao = new IUserDaoImpl();
		userDao.serchUser();
	}
	/**
	 * JDk动态代理方法
	 */
	@Test
	public void proxytest(){
		//实列化目标对象
		IUserDao target = new IUserDaoImpl();
		IUserDao proxy = ((IUserDao) Proxy.newProxyInstance(
				//目标类ClassLoad定义了有那个ClassLoad对象生成代理进行加载
				target.getClass().getClassLoader(),
				//目标类的接口,一个interface接口,表示我们将为我们的代理对象提供一组接口,如果我们吗提供一组接口给它
				//那么代理就宣称实现该接口(多态)这样我们就调用该接口中的方法了
				target.getClass().getInterfaces(),
				//匿名内部类
				new InvocationHandler(){
					/**
					 * proxy:指我们要代理的那个真实对象
					 * method:指我们要调用真是对象的方法的method对象
					 * params:指我们要调用真是方法的参数
					 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
						// TODO Auto-generated method stub
						System.out.println("添加方法...");
						System.out.println(""+method.getName());
						Object result = method.invoke(target, params);
						System.out.println("编写日志...");
						return result;
					}
					
				}));
		proxy.addUser();
		
	}
}
