package com.dqsy.mybatis.dto;

import java.util.List;

import com.dqsy.mybatis.entity.Employee;

public class EmpDto {
	private Employee employee;
	private List<Integer> ids;
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
