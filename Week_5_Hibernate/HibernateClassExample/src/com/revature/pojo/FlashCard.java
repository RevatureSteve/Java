package com.revature.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FLASH_CARDS")
public class FlashCard {
	
	@Id
	@Column(name="FC_ID")
	private int fcId;
	
	@Column(name="FC_QUESTION")
	private String fcQuestion;
	
	@Column(name="FC_ANSWER")
	private String fcAnswer;
	
	
	public FlashCard(){}


	public FlashCard(int fcId, String fcQuestion, String fcAnswer) {
		super();
		this.fcId = fcId;
		this.fcQuestion = fcQuestion;
		this.fcAnswer = fcAnswer;
	}


	public int getFcId() {
		return fcId;
	}


	public void setFcId(int fcId) {
		this.fcId = fcId;
	}


	public String getFcQuestion() {
		return fcQuestion;
	}


	public void setFcQuestion(String fcQuestion) {
		this.fcQuestion = fcQuestion;
	}


	public String getFcAnswer() {
		return fcAnswer;
	}


	public void setFcAnswer(String fcAnswer) {
		this.fcAnswer = fcAnswer;
	}


	@Override
	public String toString() {
		return "FlashCard [fcId=" + fcId + ", fcQuestion=" + fcQuestion + ", fcAnswer=" + fcAnswer + "]";
	}
	
	
	

}
