package com.revature.dao;

import java.util.List;

import com.revature.pojo.FlashCard;

public interface FlashCardDao {

	//CRUD
	public void createFC(FlashCard fc);
	
	public FlashCard retrieveFCById(Integer id);
	public List<FlashCard> retrieveAllFC();
	public void updateFC(FlashCard fc);
	public void deleteFCById(Integer id);
	
	
}
