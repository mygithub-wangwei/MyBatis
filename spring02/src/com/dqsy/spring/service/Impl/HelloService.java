package com.dqsy.spring.service.Impl;

import com.dqsy.spring.service.IHelloService;

public class HelloService implements IHelloService {

	private String name;
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("set 方法注入---->"+name);
	}
}
