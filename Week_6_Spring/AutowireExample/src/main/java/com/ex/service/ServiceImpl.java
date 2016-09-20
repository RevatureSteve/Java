package com.ex.service;

import com.ex.dao.Dao;

public class ServiceImpl implements Service {
	
	private Dao dog;

	public void setDog(Dao dog) {
		this.dog = dog;
	}

	@Override
	public void auth() {
		System.out.println("ServiceImpl");
		dog.getEmployeeById();
	}

}
