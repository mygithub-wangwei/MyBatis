package com.dqsy.spring.jdbctemplate.dao;

import java.util.List;

import com.dqsy.spring.jdbctemplate.entity.User;

/**
 * 针对用户表的CRUD操作
 * @author 王巍
 *
 */
public interface IUserDao {
	public boolean addUser(User user);
	public boolean deleteUser(Integer id);
	public boolean updateUser(User user);
	public List<User> getUserList();
}
