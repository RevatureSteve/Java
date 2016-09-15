package com.ex.main;

import com.ex.dao.DaoImpl;
import com.ex.domain.BankUser;

public class MainClass {
	public static void main(String[] args) {
		
		DaoImpl dao = new DaoImpl();
		
		BankUser john = dao.getUserById(24);
		System.out.println(john);
		
		BankUser john2 = dao.getUserById(24);
		System.out.println(john2);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BankUser john3 = dao.getUserById(24);
		System.out.println(john3);
	
	}
}
