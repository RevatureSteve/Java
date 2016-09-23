package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BANK_TX_TYPE")
public class BankTxType {
	@Id
	@Column(name="BTT_ID")
	private int bttId;
	@Column(name="TX_TYPE")
	private String txType;
	
	public BankTxType(){}

	public BankTxType(int bttId, String txType) {
		super();
		this.bttId = bttId;
		this.txType = txType;
	}

	public int getBttId() {
		return bttId;
	}

	public void setBttId(int bttId) {
		this.bttId = bttId;
	}

	public String getTxType() {
		return txType;
	}

	public void setTxType(String txType) {
		this.txType = txType;
	}

	@Override
	public String toString() {
		return "BankTxType [bttId=" + bttId + ", txType=" + txType + "]";
	};
	
	
}
