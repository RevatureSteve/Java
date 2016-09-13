package com.revature.dao;

import java.util.List;

import com.revature.domain.BankAccount;
import com.revature.domain.BankUser;

public interface BankDao {
	
	public BankUser getBankUserById(int id);
	
	public BankAccount getBankAccountById(int id);
	
	public List<BankUser> retrieveAllBankUsers();
}
