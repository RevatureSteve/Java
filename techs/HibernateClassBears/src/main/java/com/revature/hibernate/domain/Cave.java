package com.revature.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CAVE")
public class Cave {
	@Id
	@Column(name="CAVE_ID")
	@SequenceGenerator(name="CAVEID_SEQ", sequenceName="CAVEID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="CAVEID_SEQ")
	private int caveId;

	@Column(name="SQ_FOOTAGE")
	private double squareFootage;
	
	@Column(name="CAVE_TYPE")
	private String caveType;
	
	public int getCaveId() {
		return caveId;
	}
	public double getSquareFootage() {
		return squareFootage;
	}
	public void setSquareFootage(double squareFootage) {
		this.squareFootage = squareFootage;
	}
	public String getCaveType() {
		return caveType;
	}
	public void setCaveType(String caveType) {
		this.caveType = caveType;
	}
	@Override
	public String toString() {
		return "Cave [caveId=" + caveId +  " squareFootage=" + squareFootage + ", caveType="
				+ caveType + "]";
	}
	public Cave(double squareFootage, String caveType) {
		super();
		this.squareFootage = squareFootage;
		this.caveType = caveType;
	}
	public Cave() {
		super();
	}
	
	
}
