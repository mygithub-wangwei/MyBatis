package com.dqsy.mybatis.mapper;

import com.dqsy.mybatis.entity.Employee;

public interface EmployeeMapper {
	public Employee getEmployeeByIdLazyLoad(int empId);
}
