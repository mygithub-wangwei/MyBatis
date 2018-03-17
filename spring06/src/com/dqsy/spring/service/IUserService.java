package com.dqsy.spring.service;

import java.math.BigDecimal;

/**
 * 用户转账的服务
 * @author Administrator
 *
 */
public interface IUserService {

	public void operateAccount(int fromUserId, int toUserId, BigDecimal money);
	
	public void operateMulAccount(int fromUserId, int toUserId, BigDecimal money);
}
