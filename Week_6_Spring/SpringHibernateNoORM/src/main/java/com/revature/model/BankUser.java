package com.revature.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="BANK_USERS")
public class BankUser {
	
	@Id
	@Column(name="BU_ID")
	private int buId;
	
	@Column(name="BU_USERNAME")
	private String bankUsername;
	
	@Column(name="BU_PASSWORD")
	private String bankPassword;
	
	//cascade=CascadeType.ALL,
	@OneToMany(cascade=CascadeType.ALL,mappedBy="bankUser",fetch=FetchType.EAGER)
	private List<BankAccount> accounts;

	
	public BankUser() {}
	
	public BankUser(int buId, String bankUsername, String bankPassword) {
		super();
		this.buId = buId;
		this.bankUsername = bankUsername;
		this.bankPassword = bankPassword;
	}

	public int getBuId() {
		return buId;
	}

	public void setBuId(int buId) {
		this.buId = buId;
	}

	public String getBankUsername() {
		return bankUsername;
	}

	public void setBankUsername(String bankUsername) {
		this.bankUsername = bankUsername;
	}

	public String getBankPassword() {
		return bankPassword;
	}

	public void setBankPassword(String bankPassword) {
		this.bankPassword = bankPassword;
	}

	
	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "BankUser [buId=" + buId + ", bankUsername=" + bankUsername + ", bankPassword=" + bankPassword + "]";
	}
	
	
	
}
