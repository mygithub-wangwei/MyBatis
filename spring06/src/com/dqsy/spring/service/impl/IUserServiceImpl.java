package com.dqsy.spring.service.impl;

import java.math.BigDecimal;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dqsy.spring.dao.IUserDao;
import com.dqsy.spring.exception.UserAccountException;
import com.dqsy.spring.service.IUserService;



/**
 * 转账服务业务层
 * 
 * @author Administrator
 *
 */
public class IUserServiceImpl implements IUserService {

	private IUserDao userDao;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 实现转账 money : 转账金额
	 */
	@Override
	public void operateAccount(int fromUserId, int toUserId, BigDecimal money) {
		// TODO Auto-generated method stub
		System.out.println("....开始转账.....");
		System.out.println("转出金额 ： " + money);
		// 1.转出账户的金额
		try {
			BigDecimal fromAccount = userDao.getAccount(fromUserId);

			/**
			 * 当fromAccount < money 是等于-1 当fromAccount = money 是等于0 当fromAccount
			 * > money 是等于 1
			 */
			if (!(fromAccount.compareTo(money) == -1)) {
				// 2.从转出账户中扣除金额
				userDao.subMoney(fromUserId, money);	
				//int a = 1/0;
				// 3.在转入账户上加上转入金额
				userDao.addMoney(toUserId, money);
			} else {
				throw new UserAccountException("余额不足");
			}
		} catch (UserAccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("....结束转账.....");
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public void operateMulAccount(int fromUserId, int toUserId, BigDecimal money) {
		// TODO Auto-generated method stub
		System.out.println("....开始转账.....");
		BigDecimal fromAccount = userDao.getAccount(fromUserId);
		if (!(fromAccount.compareTo(money) == -1)) {
			userDao.subMoney(fromUserId, money);
			//int  a = 1/0;
			
			userDao.addMoney(toUserId, money);
		}
		System.out.println("....结束转账.....");
	}




}
