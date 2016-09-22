package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.EventService;

public class MainClass {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-beans.xml");
		
		EventService es = (EventService) ac.getBean("myAwesomeBean");
		
		es.playComedyShow();
		
		System.out.println();
	
		es.playConcert();
		
		System.out.println();
		
		es.runAmusementPark();
	}

}
