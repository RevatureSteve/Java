package com.revature.main;

import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;

public class MainClass {

	public static void main(String[] args) {

		BankDao dao = new BankDaoImpl();
		
//		dao.retrieveAllBankUsers();
		
		System.out.println(dao.getBankUserById(2));

	}

}
