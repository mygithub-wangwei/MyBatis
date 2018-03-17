package com.dqsy.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.dqsy.mybatis.dto.UserDto;
import com.dqsy.mybatis.entity.User;
import com.dqsy.mybatis.mapper.UserMapper;

public class MapperTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException{
		String configFile = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(configFile);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void TestGetUserById(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		System.out.println(userMapper.getUserById(1));
		sqlSession.close();
	}
	//查询用户
	@Test
	public void TestGetUserList(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = userMapper.getUserList(); 
		for(User u: users){
			System.out.println(u);
		}
		sqlSession.close();
	}
	//添加用户
	@Test
	public void TestAddUser(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setName("鲁金环");
		user.setPassword("123");
		user.setAge(23);
		user.setCreateTime(new Date());
		userMapper.addUser(user);	
		sqlSession.commit();
		sqlSession.close();
	}
	//删除用户
	@Test
	public void TestdelUser(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.delUser(1);	
		sqlSession.commit();
		sqlSession.close();
	}
	//修改用户
	@Test
	public void TestuptUser(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setId(2);
		user.setName("王巍");
		user.setPassword("123");
		user.setAge(23);
		user.setCreateTime(new Date());
		userMapper.uptUser(user);	
		sqlSession.commit();
		sqlSession.close();
	}
	//传多个参数
	@Test
	public void TestgetUserByIdAndPwd(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.getUserByIdAndPwd("王甜", "123");
		System.out.println(user);
		sqlSession.close();
	}
	//包装类里的查询
	@Test
	public void TestGetUserByUserDto(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserDto userDto = new UserDto();
		User user = new User();
		user.setName("王");
		userDto.setUser(user);
		List<User> users = userMapper.getUserByUserDto(userDto);
		for(User u: users){
			System.out.println(u);
		}
		sqlSession.close();
	}
	//表数量的查询
	@Test
	public void TestGetUserCount(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int a = userMapper.getUserCount();
		System.out.println(a);
		sqlSession.close();
	}
	//包装类里的查询
	@Test
	public void TestGetUserHashMap(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<Map<Object, Object>> users = userMapper.getUserListMap();
		for(Map<Object, Object> u: users){
			System.out.println(u);
		}
		sqlSession.close();
	}
	//resultMap 查询
	@Test
	public void TestGetUserResultMap(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> users = userMapper.getUserListByResultMap();
		for(User u: users){
			System.out.println(u);
		}
		sqlSession.close();
	}
}
