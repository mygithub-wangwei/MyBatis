package com.dqsy.spring.dao;

import java.math.BigDecimal;

import com.dqsy.spring.entity.User;

/**
 * 用户账户操作接口
 * @author lenovo
 *
 */
public interface IUserDao {

	/**
	 * 添加金额
	 */
	public boolean addMoney(int userId, BigDecimal money);
	
	/**
	 * 减少金额
	 */
	public boolean subMoney(int userId, BigDecimal money);
	
	/**
	 * 添加用户
	 */
	public boolean addUser(User user);
	
	/**
	 * 转出账户的金额
	 */
	public BigDecimal getAccount(int fromUserId);
}
