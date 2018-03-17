package com.dqsy.spring.jdbctemplate.entity;

import java.math.BigDecimal;

public class User {
	private int id;
	private String name;
	private BigDecimal account;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", account=" + account + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getAccount() {
		return account;
	}
	public void setAccount(BigDecimal account) {
		this.account = account;
	}
}
