package com.revature.passbyvalue;

import com.revature.pojos.Person;

public class PassByValue {

	public static void main(String[] args) {
		int x = 5;
		int y = 7;
		
		Person person = new Person("John", 29);
		
		System.out.println("x: " + x + "\ty: " + y + "\tperson: " + person );
		
		x = example(x, y, person);
		
		System.out.println("x: " + x + "\ty: " + y + "\tperson: " + person );
		

	}
	
	
	static int example(int x, int y, Person person){
		x += 10;
		y += 10;
		
		//person.setAge(30);
		person = new Person("Amy", 35);
		return x;
	}

}
