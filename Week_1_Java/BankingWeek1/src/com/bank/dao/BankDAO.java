package com.bank.dao;

import com.bank.model.Bank;

/*
 * DAO - Data Access Object
 * 
 * Created a Bank DAO 
 * 
 * I'll use this object to pass to my persistence layer
 * This will allow me to change out how I persist my data without
 * effecting the rest of my code - Decoupling Code
 * 
 */
public class BankDAO {
	
	private static final String filename = "src/com/bank/resources/bank_data.xml";
	
	//Passing my <Bank> Object as my Generic Object 
	private static final GenericDAO<Bank> dao = new GenericDAO<>();

	public boolean saveBank(Bank bank){
		return dao.save(filename, bank);
	}
	
	public Bank getBank(){
		return dao.get(filename, new Bank());
	}
}
