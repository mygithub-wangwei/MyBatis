package com.dqsy.mybatis.test;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.dqsy.mybatis.entity.Department;
import com.dqsy.mybatis.entity.Employee;
import com.dqsy.mybatis.mapper.DepartmentMapper;
import com.dqsy.mybatis.mapper.EmployeeMapper;


public class MyBatisTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException{
		String configFile = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(configFile);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	//部门单表查询
	@Test
	public void TestGetUserById(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);
		Department dept = deptMapper.getDepartmentById(1002);
		System.out.println(dept);
		sqlSession.close();
	}
	//员工单表查询
	@Test
	public void TestGetEmployeeLazyLoad(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeMapper empMapper = sqlSession.getMapper(EmployeeMapper.class);
		Employee emp = empMapper.getEmployeeByIdLazyLoad(40);
		System.out.println(emp);
		sqlSession.close();
	}
	//一级缓存查询
		@Test
		public void TestOneCache(){
			SqlSession sqlSession = sqlSessionFactory.openSession();
			DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);
			Department dept = deptMapper.getDepartmentById(1002);
			System.out.println(dept);
			sqlSession.commit();
			System.out.println("=========================================");
			DepartmentMapper deptMapper1 = sqlSession.getMapper(DepartmentMapper.class);
			Department dept1 = deptMapper1.getDepartmentById(1002);
			System.out.println(dept1);
			sqlSession.commit();
			sqlSession.close();
		}
		//二级缓存查询
		@Test
		public void TestOneCache2(){
			SqlSession sqlSession = sqlSessionFactory.openSession();
			DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);
			Department dept = deptMapper.getDepartmentById(1002);
			System.out.println(dept);
			sqlSession.close();
			
			System.out.println("=========================================");
			
			SqlSession sqlSession1 = sqlSessionFactory.openSession();
			DepartmentMapper deptMapper1 = sqlSession1.getMapper(DepartmentMapper.class);
			Department dept1 = deptMapper1.getDepartmentById(1002);
			System.out.println(dept1);
			sqlSession.close();
		}
	
}
