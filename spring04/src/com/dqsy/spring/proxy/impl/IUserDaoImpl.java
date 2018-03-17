package com.dqsy.spring.proxy.impl;

import com.dqsy.spring.proxy.IUserDao;

public class IUserDaoImpl implements IUserDao {

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		/**
		 * 业务逻辑服务
		 */
		/**
		 * 首先进行权限的判断
		 */
		
		//System.out.println("判断权限....");
		System.out.println("添加方法....");
		/**
		 * 编写日志
		 * 
		 */
		//System.out.println("编写日志");
//		int a = 1/0;//后面的异常通知会用到
	}

	@Override
	public void serchUser() {
		// TODO Auto-generated method stub
		System.out.println("寻找方法....");
	}

}
