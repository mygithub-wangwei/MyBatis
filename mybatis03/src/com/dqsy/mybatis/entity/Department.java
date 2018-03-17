package com.dqsy.mybatis.entity;

import java.util.List;

public class Department {
	private int deptId;
	private String deptName;
	//private Admin admin;
	private List<Department> emps;
	public List<Department> getEmps() {
		return emps;
	}
	public void setEmps(List<Department> emps) {
		this.emps = emps;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/*public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", admin=" + admin + "]";
	}*/
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", emps=" + emps + "]";
	}
}
