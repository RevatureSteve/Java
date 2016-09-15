package com.ex.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="BANK_USERS")
@Cache(region="myAwesomeCache", usage = CacheConcurrencyStrategy.READ_ONLY)
public class BankUser {
	
	@Id
	@Column(name="BU_ID")
	private Integer id;
	
	@Column(name="BU_USERNAME")
	private String username;
	
	@Column(name="BU_PASSWORD")
	private String password;
	
	@OneToMany(mappedBy="bankUser", fetch=FetchType.LAZY)
	private List<BankAccount> accounts;
	
	
	
	
	
	public BankUser(){}
	
	public BankUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public BankUser(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
	
	

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "BankUser [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
