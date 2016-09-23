package com.revature.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BANK_TX")
public class BankTx {

	@Id
	@Column(name="BT_ID")
	private int btId;
	
	@Column(name="BA_ID")
	private int baId;
	
	@ManyToOne
	@JoinColumn(name="BTT_ID")
	private BankTxType bttId;
	
	@Column(name="TX_AMOUNT")
	private double txAmount;
	
	@Column(name="TX_TS")
	private Timestamp timestamp;
	
	public BankTx(){}

	public BankTx(int btId, int baId, BankTxType bttId, double txAmount, Timestamp timestamp) {
		super();
		this.btId = btId;
		this.baId = baId;
		this.bttId = bttId;
		this.txAmount = txAmount;
		this.timestamp = timestamp;
	}

	public int getBtId() {
		return btId;
	}

	public void setBtId(int btId) {
		this.btId = btId;
	}

	public int getBaId() {
		return baId;
	}

	public void setBaId(int baId) {
		this.baId = baId;
	}

	public BankTxType getBttId() {
		return bttId;
	}

	public void setBttId(BankTxType bttId) {
		this.bttId = bttId;
	}

	public double getTxAmount() {
		return txAmount;
	}

	public void setTxAmount(double txAmount) {
		this.txAmount = txAmount;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "BankTx [btId=" + btId + ", baId=" + baId + ", bttId=" + bttId + ", txAmount=" + txAmount
				+ ", timestamp=" + timestamp + "]";
	}
	
	
	
}
