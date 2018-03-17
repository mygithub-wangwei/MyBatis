package com.dqsy.mybatis.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.dqsy.mybatis.dto.EmpDto;
import com.dqsy.mybatis.entity.Admin;
import com.dqsy.mybatis.entity.Department;
import com.dqsy.mybatis.entity.Employee;
import com.dqsy.mybatis.mapper.AdminMapper;
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
	@Test
	public void TestGetUserById(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeMapper empMapper = sqlSession.getMapper(EmployeeMapper.class);
		EmpDto empDto = new EmpDto();
		Employee employee = new Employee();
		employee.setEmpName("吴");
		employee.setGender("男");
		empDto.setEmployee(employee);
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1000);
		ids.add(1001);
		ids.add(1002);
		List<Employee> emps = empMapper.getEmpByEmpDto(empDto);
		for(Employee emp : emps){
			System.out.println(emp);
		}
		sqlSession.close();
	}
	@Test
	public void TestSelectKey(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		Admin  admin= new Admin();
		admin.setName("大庆师范");
		adminMapper.addAdmin(admin);
		sqlSession.commit();
		sqlSession.close();
	}
	//一对一查询方法一
	@Test
	public void TestGetAdminAll(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
		List<Admin> admins = adminMapper.getAdminAll();
		for(Admin admin: admins){
			System.out.println(admin);
		}
		sqlSession.close();
	}
	//一对一查询方法二
	@Test
	public void TestGetDepartmentTypeTwo(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);
		List<Department> depts = deptMapper.getDepartmentTypeTwo();
		for(Department dept: depts){
			System.out.println(dept);
		}
		sqlSession.close();
	}
	//一对多查询方法一
	@Test
	public void TestGetDepartmentEmp(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		DepartmentMapper deptMapper = sqlSession.getMapper(DepartmentMapper.class);
		List<Department> depts = deptMapper.getDepartmentEmp(1001);
		for(Department dept: depts){
			System.out.println(dept);
		}
		sqlSession.close();
	}
}
