package com.flashcard.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.flashcard.dao.FlashCardDAO;
import com.flashcard.dao.FlashCardDAOImpl;
import com.flashcard.domain.FlashCard;

public class FlashCardService {

	public FlashCard getRandomFlashCard() {

		FlashCardDAO dao = new FlashCardDAOImpl();

		List<FlashCard> flashCards = dao.retrieveAllFlashCards();
		int size = flashCards.size();

		if (size > 0) {
			
			Random random = new Random();
			int index = random.nextInt(flashCards.size());

			return flashCards.get(index);
			
		} else {
			return null;
		}
	}

}
