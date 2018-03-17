package com.dqsy.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dqsy.mybatis.dao.IStudentDao;
import com.dqsy.mybatis.entity.Student;

public class IStudentDaoImpl implements IStudentDao {
	//通过构造方法把sqlSessionFactory加载进来
	private SqlSessionFactory sqlSessionFactory;
	public IStudentDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		SqlSession  sqlSession = sqlSessionFactory.openSession();
		Student stu = sqlSession.selectOne("com.dqsy.mybatis.xml.StudentMapper.getStudentById", id);
		sqlSession.close();
		return stu;
	}

	@Override
	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		SqlSession  sqlSession = sqlSessionFactory.openSession();
		List<Student> stus = sqlSession.selectList("com.dqsy.mybatis.xml.StudentMapper.getStudentList");
		sqlSession.close();
		return stus;
	}

	@Override
	public void addStudent(Student stu) {
		// TODO Autoerated method stub
		SqlSession  sqlSession = sqlSessionFactory.openSession();
		int rows = sqlSession.insert("com.dqsy.mybatis.xml.StudentMapper.addStudent", stu);
		System.out.println("行数"+rows);
		sqlSession.commit();
		sqlSession.close();

	}

	@Override
	public void delStudent(int id) {
		// TODO Auto-generated method stub
		SqlSession  sqlSession = sqlSessionFactory.openSession();
		int rows = sqlSession.delete("com.dqsy.mybatis.xml.StudentMapper.delStudent", id);
		System.out.println("行数"+rows);
		sqlSession.commit();
		sqlSession.close();
		
	}

	@Override
	public void uptStudent(Student stu) {
		// TODO Auto-generated method stub
		SqlSession  sqlSession = sqlSessionFactory.openSession();
		int rows = sqlSession.update("com.dqsy.mybatis.xml.StudentMapper.uptStudent", stu);
		System.out.println("行数"+rows);
		sqlSession.commit();
		sqlSession.close();
	}

}
