package com.revature.pojos;

public class Person {

	private  int age;
	private String name;
	
	
	//No-args Constructor
	public Person() {
		System.out.println("Inside no args constructor of Person");
		
	} // this will be provided when no other constructor was given
	
	//Overloaded Constructor
	public Person(String name, int age){
		System.out.println("Person( name and age)");
		this.name = name;
		this.age = age;
	}

	
		public static boolean getTrue(){
			return true;
		}

		/*
		 * Encapsulation - keeps code from being randomly accessed
		 */
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}
		
		//Age must be 18 or older and other developers can't set the age directly
		public void setAge(int age) {
			if(age < 18){
				this.age = 18;
			}else{
				this.age = age;
			}
		}
}
