package com.dqsy.spring.jdbctemplate.service.impl;

import java.util.List;

import com.dqsy.spring.jdbctemplate.dao.IUserDao;
import com.dqsy.spring.jdbctemplate.entity.User;
import com.dqsy.spring.jdbctemplate.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao userDao;
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.addUser(user);
	}

	@Override
	public boolean deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return this.userDao.deleteUser(id);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.updateUser(user);
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return this.userDao.getUserList();
	}

}
