package com.dqsy.spring.service.Impl;

import java.util.List;

import com.dqsy.spring.dao.CarDao;
import com.dqsy.spring.service.UserService;

public class UserServiceImpl implements UserService {
	private String name;
	//private CarDao car;
	private List<CarDao> cars;
	public void setCars(List<CarDao> cars) {
		this.cars = cars;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/*public void setCar(CarDao car) {
		this.car = car;
	}*/

	public void drive() {
		for(CarDao car: cars){
			System.out.println(name +"驾驶"+car.run());
		}
		
	}

}
