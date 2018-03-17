package com.dqsy.mybatis.mapper;

import java.util.List;

import com.dqsy.mybatis.entity.Department;

public interface DepartmentMapper {
	public List<Department> getDepartmentTypeTwo();
	public List<Department> getDepartmentEmp(int deptId);
}
