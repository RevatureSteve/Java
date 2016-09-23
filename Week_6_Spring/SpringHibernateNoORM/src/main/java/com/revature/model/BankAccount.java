package com.revature.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="BANK_ACCOUNTS")
public class BankAccount {
	
	@Id
	@Column(name="BA_ID")
	private int baId;
	
	@Column(name="BA_BALANCE")
	private double baBalance;
	
	@ManyToOne
	@JoinColumn(name="BU_ID")
	private BankUser bankUser;
	
//	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="baId")
	private List<BankTx> bankTx;
	
	
	public BankAccount() {}
	
	public BankAccount(int baId, double baBalance, BankUser bankUser) {
		super();
		this.baId = baId;
		this.baBalance = baBalance;
		this.bankUser = bankUser;
	}

	public int getBaId() {
		return baId;
	}

	public void setBaId(int baId) {
		this.baId = baId;
	}

	public double getBaBalance() {
		return baBalance;
	}

	public void setBaBalance(double baBalance) {
		this.baBalance = baBalance;
	}

	public BankUser getBuId() {
		return bankUser;
	}

	public void setBuId(BankUser bankUser) {
		this.bankUser = bankUser;
	}
	
	

	@Override
	public String toString() {
		return "BankAccount [baId=" + baId + ", baBalance=" + baBalance + ", buId=" + bankUser + "]";
	}

	public List<BankTx> getBankTx() {
		return bankTx;
	}

	public void setBankTx(List<BankTx> bankTx) {
		this.bankTx = bankTx;
	}
	
}
