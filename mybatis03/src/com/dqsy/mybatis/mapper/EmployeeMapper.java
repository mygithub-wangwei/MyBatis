package com.dqsy.mybatis.mapper;

import java.util.List;

import com.dqsy.mybatis.dto.EmpDto;
import com.dqsy.mybatis.entity.Employee;

public interface EmployeeMapper {
	public List<Employee> getEmpByEmpDto(EmpDto empDto);
}
