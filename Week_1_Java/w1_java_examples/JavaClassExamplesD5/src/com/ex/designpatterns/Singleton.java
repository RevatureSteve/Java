package com.ex.designpatterns;

public class Singleton {

	private static Singleton singleton = new Singleton();
	
	/*
	 * A private Constructor prevents any other class from instantiating.
	 */
	private Singleton() {}

	/* Static 'instance' method */
	public static Singleton getInstance() {
		return singleton;
	}
	
	public void sayHello(){
		System.out.println("Hello Singleton");
	}
}