package com.dqsy.mybatis.dto;

import com.dqsy.mybatis.entity.User;

public class UserDto implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
