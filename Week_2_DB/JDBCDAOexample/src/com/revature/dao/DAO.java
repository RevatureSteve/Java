package com.revature.dao;

import java.util.List;

import com.revature.pojo.FlashCard;

public interface DAO {
	
	//Insert  - Statement
	public void createFlashCard(FlashCard flashCard);
	
	//Read
	public List<FlashCard> retrieveAllFlashCards();
	
	//Update
	public int updateFlashCard(FlashCard flashCard);
	
	//Delete
	public int deleteFlashCard(FlashCard flashCard);
	
	//Insert for PreparedStatement
	public void createFlashCardPreparedStatement(FlashCard flashCard);
	
}
