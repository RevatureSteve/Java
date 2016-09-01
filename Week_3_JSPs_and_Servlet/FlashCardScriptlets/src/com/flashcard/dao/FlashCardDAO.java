package com.flashcard.dao;

import java.util.List;

import com.flashcard.domain.FlashCard;

public interface FlashCardDAO {
	
	public List<FlashCard> retrieveAllFlashCards();
	
}
