package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.revature.domain.BankAccount;
import com.revature.domain.BankTx;
import com.revature.domain.BankUser;
import com.revature.util.ConnectionUtil;

public class BankDaoImpl implements BankDao{

	@SuppressWarnings("unchecked")
	public List<BankUser> retrieveAllBankUsers(){
		Session session = ConnectionUtil.getSession();
		
		Criteria criteria = session.createCriteria(BankUser.class);
		List<BankUser> bankUsers = criteria.list();
		
		for(BankUser bankUser : bankUsers){
			System.out.println(bankUser);
			for(BankAccount bankAccount : bankUser.getAccounts()){
				System.out.println(bankAccount);
				for(BankTx bankTx : bankAccount.getBankTx()){
					System.out.println(bankTx);
				}
			}
			
			System.out.println("---------\n");
		}
		
		session.close();
		System.out.println(bankUsers.get(1).toString());
		return bankUsers;
	}
 	
	
	@Override
	public BankUser getBankUserById(int id) {
		Session session = ConnectionUtil.getSession();
		
		BankUser bankUser = (BankUser) session.get(BankUser.class, id);
		
		System.out.println(bankUser + " pulled in the DAO!");

		
		session.close();
		return bankUser;
	}
	
	@Override
	public BankAccount getBankAccountById(int id){
		Session session = ConnectionUtil.getSession();
		
		BankAccount bankAccount = (BankAccount) session.get(BankAccount.class, id);
		
		
		session.close();
		
		return bankAccount;
	}


}
