package com.ex.designpatterns;

public class MainClass {

	public static void main(String[] args) {
		
		/**
		 *	Singleton Design Pattern
		 *
		 * Get the one and only instantiated object of the Class Singleton
		 */
		Singleton singleton = Singleton.getInstance();
		singleton.sayHello();
		
		System.out.println();
		
		/**
		 * Factory Design Pattern
		 *  
		 * Create object without exposing the creation logic to the client
		 * and refer to newly created object using a common interface.
		 */
		ToolBoxFactory tbf = new ToolBoxFactory();
		ToolBox tbHammar = tbf.workWithTool("hammer");
		
		ToolBox tbWrench = tbf.workWithTool("wrench");
		
		System.out.println("Need to work with a hammer: " + tbHammar.workWithTool());
		System.out.println("Need to work with a wrench: " + tbWrench.workWithTool());
	}

}
