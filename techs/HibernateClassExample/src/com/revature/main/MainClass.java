package com.revature.main;

import com.revature.dao.FlashCardDao;
import com.revature.dao.FlashCardDaoImpl;
import com.revature.pojo.FlashCard;

public class MainClass {

	public static void main(String[] args) {
		FlashCard fc = new FlashCard(12,"What time is it?12","IT's 12!");
		
		FlashCardDao dao = new FlashCardDaoImpl();
		
		//dao.createFC(fc);
		//dao.retrieveFCById(10);
		
		System.out.println(dao.retrieveAllFC());
		
		dao.updateFC(fc);
		System.out.println(  "FC Updated!" );
		
		dao.deleteFCById(12);
		
		System.out.println("12 has been destroyed");
		System.out.println("HIBERNATED");
	}

}
