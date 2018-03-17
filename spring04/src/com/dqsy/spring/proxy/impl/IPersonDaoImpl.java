package com.dqsy.spring.proxy.impl;

import com.dqsy.spring.proxy.IPersonDao;

public class IPersonDaoImpl implements IPersonDao {

	@Override
	public void addStudent() {
		// TODO Auto-generated method stub
		System.out.println("为一个学员添加课程信息");
	}

	@Override
	public void modify() {
		// TODO Auto-generated method stub
		System.out.println("为一个学员修改课程信息");

	}

}
