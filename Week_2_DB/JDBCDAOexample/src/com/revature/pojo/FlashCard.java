package com.revature.pojo;

public class FlashCard {

	private int fc_id;
	private String question;
	private String answer;
	
	
	public FlashCard() {
		super();
	}
	
	public FlashCard(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}
	
	//Not using much as our sequence will be used
	public FlashCard(int fc_id, String question, String answer) {
		super();
		this.fc_id = fc_id;
		this.question = question;
		this.answer = answer;
	}

	public int getFc_id() {
		return fc_id;
	}

	public void setFc_id(int fc_id) {
		this.fc_id = fc_id;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "FlashCard [fc_id=" + fc_id + ", question=" + question + ", answer=" + answer + "]";
	}
	
	
	
}
