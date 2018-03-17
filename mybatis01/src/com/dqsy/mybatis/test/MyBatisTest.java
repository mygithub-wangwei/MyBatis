package com.dqsy.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.dqsy.mybatis.dao.IStudentDao;
import com.dqsy.mybatis.dao.impl.IStudentDaoImpl;
import com.dqsy.mybatis.entity.Student;

public class MyBatisTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException{
		//1.读取配置文件
				String configFile = "mybatis-config.xml";
				InputStream inputStream = Resources.getResourceAsStream(configFile);
				//2.通过SqlSessionFactoryBuilder建立sqlSessionFactory
				 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Ignore
	@Test
	public void TestGetStudentById(){
		IStudentDao stuDao = new IStudentDaoImpl(sqlSessionFactory);
		System.out.println(stuDao.getStudentById(1));
	}
	@Ignore
	@Test
	public void TestGetStudentList(){
		IStudentDao stuDao = new IStudentDaoImpl(sqlSessionFactory);
		List<Student> stus = stuDao.getStudentList();
		for(Student stu: stus){
			System.out.println(stu);
		}	
	}
	//@Ignore
	@Test
	public void TestAddStudent(){
		IStudentDao stuDao = new IStudentDaoImpl(sqlSessionFactory);
		Student stu = new Student();
		stu.setName("王巍");
		stu.setAge(25);
		stu.setCreateTime(new Date());
		stuDao.addStudent(stu);
	}
	@Ignore
	@Test
	public void TestDelStudent(){
		IStudentDao stuDao = new IStudentDaoImpl(sqlSessionFactory);
		stuDao.delStudent(1);
	}
	@Test
	public void TestUptStudent(){
		IStudentDao stuDao = new IStudentDaoImpl(sqlSessionFactory);
		Student stu = new Student();
		stu.setId(5);
		stu.setName("可鑫");
		stu.setAge(28);
		stu.setCreateTime(new Date());
		stuDao.uptStudent(stu);
	}
}
