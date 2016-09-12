package com.revature.main;

import com.revature.dao.FlashCardDao;
import com.revature.dao.FlashCardDaoImpl;
import com.revature.pojo.FlashCard;

public class MainClass {

	public static void main(String[] args) {
		FlashCard fc = new FlashCard(11,"What time is it?1","Hibernate Time1");
		
		FlashCardDao dao = new FlashCardDaoImpl();
		
		dao.createFC(fc);
		System.out.println("HIBERNATED");
	}

}
