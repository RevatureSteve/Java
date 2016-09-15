package com.revature.hibernate.main;

import org.hibernate.Session;

import com.revature.hibernate.util.HibernateConnUtil;

public class App 
{
    public static void main( String[] args )
    {
       
       Session session = HibernateConnUtil.getSession();
       
       
    }
}
