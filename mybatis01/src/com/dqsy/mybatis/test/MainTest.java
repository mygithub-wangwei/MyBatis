package com.dqsy.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dqsy.mybatis.entity.Student;

public class MainTest {

	public static void main(String[] args) throws IOException {
		//1.读取配置文件
		String configFile = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(configFile);
		//2.通过SqlSessionFactoryBuilder建立sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//3.通过sqlSessionFactory创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.通过sqlSession接口方法开执行数据库
		Student stu = sqlSession.selectOne("com.dqsy.mybatis.xml.StudentMapper.getStudentById", 1);
		//5.测试
		System.out.println(stu);
		//6.关闭sqlSession
		sqlSession.close();
	}

}
