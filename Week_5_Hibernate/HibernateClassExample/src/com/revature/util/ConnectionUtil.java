package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionUtil {

	 @SuppressWarnings("deprecation")
	private static SessionFactory sessionFactory = 
			 new Configuration()
			 	.configure("com/revature/resources/hibernate.cfg.xml")
			 	.buildSessionFactory();
	
	 public static Session getSession() {
			return sessionFactory.openSession();
		}
}
