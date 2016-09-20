package com.revature.main;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;
import com.revature.domain.BankAccount;
import com.revature.domain.BankUser;

public class MainClass {

	public static void main(String[] args) {

		BankDao dao = new BankDaoImpl();
		
//		dao.retrieveAllBankUsers();
		
//		System.out.println(dao.getBankUserById(2));
		
//		dao.updateVsMerge();
		
		BankUser bankUser = new BankUser(37,"Tommy3","Myspace");
		List<BankAccount> accounts = new ArrayList<>();
		
		accounts.add(new BankAccount(37,1999,bankUser));
		
		bankUser.setAccounts(accounts);
		
		dao.saveBankUser(bankUser);
	}

}
