package com.ex.dao;

import java.util.List;

import com.ex.domain.FlashCard;

public interface Dao {
	
	public void saveFC(FlashCard fc);
	public List<FlashCard> getAllFC();
	public FlashCard getFlashCardById(Integer id);
	
}
