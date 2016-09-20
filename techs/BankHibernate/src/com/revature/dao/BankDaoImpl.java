package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.BankAccount;
import com.revature.domain.BankTx;
import com.revature.domain.BankUser;
import com.revature.util.ConnectionUtil;

import monfox.toolkit.snmp.agent.modules.SnmpV2Mib.SysOREntry;

public class BankDaoImpl implements BankDao {

	@SuppressWarnings("unchecked")
	public List<BankUser> retrieveAllBankUsers() {
		Session session = ConnectionUtil.getSession();

		Criteria criteria = session.createCriteria(BankUser.class);
		List<BankUser> bankUsers = criteria.list();

		for (BankUser bankUser : bankUsers) {
			System.out.println(bankUser);
			for (BankAccount bankAccount : bankUser.getAccounts()) {
				System.out.println(bankAccount);
				for (BankTx bankTx : bankAccount.getBankTx()) {
					System.out.println(bankTx);
					System.out.println(bankTx.getBttId());
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

		BankUser bankUserLoad = (BankUser) session.load(BankUser.class, id);
		System.out.println(bankUserLoad.getClass() + " -LOAD- pulled in the DAO!");

		BankUser bankUserGet = (BankUser) session.get(BankUser.class, id);
		System.out.println(bankUserGet.getClass() + " -GET- pulled in the DAO!");

		session.close();
		return bankUserGet;
	}

	@Override
	public BankAccount getBankAccountById(int id) {
		Session session = ConnectionUtil.getSession();

		BankAccount bankAccount = (BankAccount) session.get(BankAccount.class, id);

		session.close();

		return bankAccount;
	}

	public void updateVsMerge() {

		System.out.println("--------------Session One---------------");
		/*
		 * Session Update
		 */
		Session sessionOne = ConnectionUtil.getSession();
		Transaction tx = sessionOne.beginTransaction();

		// Transient state
		BankUser john = new BankUser(3, "Austin", "123");

		// After update John becomes in the
		// Persistent State - Allows Dirty Checking
		sessionOne.update(john);
		john.setBankPassword("123AfterUpdate");

		// Merge did not bring the object into
		// the Persistent state - doesn't allow dirty checking
		// sessionOne.merge(john);
		// john.setBankPassword("123AfterUpdateMerge");

		System.out.println("-----Before Commit-------");

		tx.commit();

		System.out.println("-----Commit Update------\n");
		sessionOne.close();

		System.out.println("------------SESSION 2------------\n");

		/*
		 * Session Merge
		 */
		Session sessionTwo = ConnectionUtil.getSession();
		Transaction tx2 = sessionTwo.beginTransaction();

		BankUser anotherJohn = (BankUser) sessionTwo.get(BankUser.class, 3);
		anotherJohn.setBankPassword("anotherJohn's Password -GET-");
		System.out.println("Before Update John ");
		john.setBankPassword("johnDetached");
		sessionTwo.merge(john);
		System.out.println("After Update John ");
		// Can't Use Update on john
		// john is detached
		// sessionTwo.update(anotherJohn);
		System.out.println("Before Commit session 2");
		tx2.commit();
		System.out.println("After Commit session 2");
		sessionTwo.close();
	}

	@Override
	public void saveBankUser(BankUser bankUser) {
		Session session = ConnectionUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(bankUser);
		tx.commit();
		session.close();
		
	}

	

	
	
}
