package com.dqsy.spring.jdbctemplate.service;

import java.util.List;

import com.dqsy.spring.jdbctemplate.entity.User;

public interface IUserService {
	public boolean addUser(User user);
	public boolean deleteUser(Integer id);
	public boolean updateUser(User user);
	public List<User> getUserList();
}
