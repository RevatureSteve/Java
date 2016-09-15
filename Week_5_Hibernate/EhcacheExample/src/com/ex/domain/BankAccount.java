package com.ex.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="BANK_ACCOUNTS")
public class BankAccount {
	
	@Id
	@Column(name="BA_ID")
	private Integer id;
	
	@Column(name="BA_BALANCE")
	private Double balance;
	
	@ManyToOne
	@JoinColumn(name="bu_id")
	private BankUser bankUser;
	
	public BankAccount(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	

	public BankUser getBankUser() {
		return bankUser;
	}

	public void setBankUser(BankUser bankUser) {
		this.bankUser = bankUser;
	}

	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", balance=" + balance + "]";
	}
	
}
