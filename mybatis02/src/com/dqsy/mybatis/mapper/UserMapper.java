package com.dqsy.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.dqsy.mybatis.dto.UserDto;
import com.dqsy.mybatis.entity.User;

public interface UserMapper {
	public User getUserById(int id);
	public List<User> getUserList();
	public void addUser(User user);
	public void delUser(int i);
	public void uptUser(User user);
	/**
	 * 用户名密码登陆
	 */
	public User getUserByIdAndPwd(String name, String pwd);
	//通过包装类查询
	public List<User> getUserByUserDto(UserDto userDto);
	//统计表的数量
	public int getUserCount();
	//返回HashMap
	public List<Map<Object, Object>> getUserListMap();
	//返回resultType
	public List<User> getUserListByResultMap();
}
