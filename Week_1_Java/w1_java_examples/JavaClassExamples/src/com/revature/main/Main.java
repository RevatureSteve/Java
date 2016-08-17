package com.revature.main;

//ctrl + shift + o to organize imports
import com.revature.pojos.*;



public class Main {
	
	
	public static void main(String[] args) {
		//System.out.println(z); //z is static so it belongs to that class
		
		//System.out.println(name); error! must be instantiated
		
		//Calling Person's No arg constructor
		Person john = new Person();
		
		//Calling Person's Overloaded Constructor
		Person steve = new Person("Steve", 18);
		
		
		System.out.println(john.getName());
		john.setName("John");
		System.out.println(john.getName());
		
		john.setAge(17);
		System.out.println(john.getAge());
		
		john.getTrue(); //we have the ability
		Person.getTrue(); //but better to use Class name
	}
}
