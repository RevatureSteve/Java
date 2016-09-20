package com.revature.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "HONEYPOT")
public class HoneyPot {	

	@Id
	@Column(name = "HONEYPOT_ID")
	@SequenceGenerator(name="HONEYPOTID_SEQ", sequenceName="HONEYPOTID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="HONEYPOTID_SEQ")
	private int honeypotId;

	@Column
	private double volume;
	
	@Column(name = "HONEY_AMOUNT")
	private double honeyAmount;

	public int getHoneypotId() {
		return honeypotId;
	}

	public void setHoneypotId(int honeypotId) {
		this.honeypotId = honeypotId;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getHoneyAmount() {
		return honeyAmount;
	}

	public void setHoneyAmount(double honeyAmount) {
		this.honeyAmount = honeyAmount;
	}

	public HoneyPot(double volume, double honeyAmount) {
		super();
		this.volume = volume;
		this.honeyAmount = honeyAmount;
	}

	public HoneyPot() {
		super();
	}

	@Override
	public String toString() {
		return "HoneyPot [volume=" + volume + ", honeyAmount=" + honeyAmount + "]";
	}

}
