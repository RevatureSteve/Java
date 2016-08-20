package com.bank.model;

import javax.xml.bind.annotation.XmlRootElement;

//POJO User
@XmlRootElement
public class BankUser implements BankObject {
	
	private String username;
	private String password;
	private Double balance;
	
	
	/*
	 * Overloaded Constructors
	 */
	public BankUser(){}

	public BankUser(String username, String password, Double balance) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
	/*
	 * Getters and Settor aka Accessors and Mutators
	 */
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankUser [username=" + username + ", password=" + password + ", balance=" + balance + "]";
	}
	
}
