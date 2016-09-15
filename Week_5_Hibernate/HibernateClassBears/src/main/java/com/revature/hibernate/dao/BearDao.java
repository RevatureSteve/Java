package com.revature.hibernate.dao;

import com.revature.hibernate.domain.Bears;

public interface BearDao {

	  public void createBearsDemo();
	  
	  public Bears getOrLoad(int id);
	  
	  public void criteriaDemo();
	  
	  public void queryDemo();
	
}
