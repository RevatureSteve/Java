package com.revature.beans;

import java.io.Serializable;

/*
 * JavaBean
 * 1. Encapsulate Variable - have getters/setters
 * 2. Implement Serializable
 * 3. No-arg Constructor
 */

public class UserBean implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3090392760219789410L;
	
	private String scopeType;
	
	public UserBean() {}

	public String getScopeType() {
		return scopeType;
	}

	public void setScopeType(String scopeType) {
		this.scopeType = scopeType;
	}
	
	

}
