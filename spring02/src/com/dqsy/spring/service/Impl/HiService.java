package com.dqsy.spring.service.Impl;

import com.dqsy.spring.service.IHelloService;

public class HiService implements IHelloService {
	private String name;
	public HiService(String name){
		this.name=name;
	}
	@Override
	public void say() {
		System.out.println("constructor 构造器方法注入---->"+name);
	}

}
