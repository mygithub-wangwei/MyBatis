package com.dqsy.spring.dao.Impl;

import com.dqsy.spring.dao.CarDao;

public class FoodCarDaoImpl implements CarDao {
	private String company;
	
	private String brand;
	
	private int maxSpeed;
	
	
	public void setCompany(String company) {
		this.company = company;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	@Override
	public String toString() {
		return "FoodCarDaoImpl [company=" + company + ", brand=" + brand + ", maxSpeed=" + maxSpeed + "]";
	}
	@Override
	public String run() {
		return toString();
	}

}
