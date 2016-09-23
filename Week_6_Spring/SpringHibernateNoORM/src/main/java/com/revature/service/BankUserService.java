package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.dao.Dao;
import com.revature.model.BankUser;

@Component
public class BankUserService {

	@Autowired
	Dao dao;
	
	public BankUser authBankUser(BankUser unauthUser){
		dao.getBankUserByUsername(unauthUser.getBankUsername());
		
		return null;
	}
	
}
