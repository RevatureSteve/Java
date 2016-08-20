package com.bank.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//My Bank POJO
@XmlRootElement(name="bank")
public class Bank implements BankObject {
	
	private List<BankUser> users;
	
	public Bank(){}

	public Bank(List<BankUser> users) {
		super();
		this.users = users;
	}

	public List<BankUser> getUsers() {
		return users;
	}
	
	@XmlElement(name="user")
	public void setUsers(List<BankUser> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Bank [users=" + users + "]";
	}
	
	
	
}
