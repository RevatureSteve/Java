package com.revature.service;

import org.springframework.stereotype.Component;

@Component(value="myAwesomeBean")
public class EventService {

	public void playComedyShow(){
		
		System.out.println("---------------");
		System.out.println("Comedy Show Plays!");
		System.out.println("---------------");
		
	}
	
	
	public void playConcert(){
		
		System.out.println("---------------");
		System.out.println("Concert Plays");
		System.out.println("---------------");
	}
	
	public void runAmusementPark(){
		System.out.println("---------------");
		System.out.println("Ausement park runs");
		System.out.println("---------------");
	}
}
