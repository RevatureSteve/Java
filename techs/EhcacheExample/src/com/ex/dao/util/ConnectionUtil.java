package com.ex.dao.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {
	
	private static SessionFactory sessionFactory = new Configuration().configure("com/ex/resources/hibernate.cfg.xml").buildSessionFactory();
		
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
}