package com.revature.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.model.BankUser;

@Component
public class DaoBankUserImpl implements Dao{


	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	@Override
	public BankUser getBankUserByUsername(String bankUsername) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from BankUser AS b WHERE b.bankUsername = :username");
		query.setParameter("username", bankUsername);
		BankUser user = (BankUser) query.uniqueResult();
		System.out.println(user + " user from DAO");
		
		session.close();
		
		return user;
	}

}
