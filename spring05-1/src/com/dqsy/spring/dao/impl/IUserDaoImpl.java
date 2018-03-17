package com.dqsy.spring.dao.impl;

import org.springframework.stereotype.Component;

import com.dqsy.spring.dao.IUserDao;
@Component(value="userDao")
public class IUserDaoImpl implements IUserDao {
	@Override
	public void addUser() {
		// TODO Auto-generated method stub
			System.out.println("添加用户");
	}
	@Override
	public void getUser() {
		// TODO Auto-generated method stub
		System.out.println("查找用户");
	}
	@Override
	public void updateUser() {
		// TODO Auto-generated method stub
		System.out.println("更改用户");
	}
	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		System.out.println("删除用户");
		int i = 1/0;
	}
}
