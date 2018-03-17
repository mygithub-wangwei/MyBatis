package com.dqsy.mybatis.dao;

import java.util.List;

import com.dqsy.mybatis.entity.Student;

public interface IStudentDao {
	
	public Student getStudentById(int id);
	public List<Student> getStudentList();
	public void addStudent(Student stu);
	public void delStudent(int id);
	public void uptStudent(Student stu);
}
