package com.revature.hibernate.main;

import com.revature.hibernate.dao.BearDaoImpl;

public class App 
{
    public static void main( String[] args )
    {
//    	new BearDaoImpl().createBearsDemo();
//       new BearDaoImpl().criteriaDemo();
//    	new BearDaoImpl().queryDemo();
    	new BearDaoImpl().getBearById(50);
    	System.out.println("One");
    	new BearDaoImpl().getBearById(50);
    }
    
    
  
}
