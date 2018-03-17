package com.dqsy.spring.dao.Impl;

import com.dqsy.spring.dao.CarDao;

public class LuHuCarDaoImpl implements CarDao {
    @Override
	public String toString() {
		return "LuHuCarDaoImpl [company=" + company + ", brand=" + brand + ", price=" + price + "]";
	}
	private String company;
	
	
	public LuHuCarDaoImpl(String company, String brand, float price) {
		super();
		this.company = company;
		this.brand = brand;
		this.price = price;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	private String brand;
	
	
	private float price;
	@Override
	public String run() {
		// TODO Auto-generated method stub
		return toString();
	}

}
