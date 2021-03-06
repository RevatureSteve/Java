package com.revature.casting;

class Parent{
	public void whichClass(){ System.out.println("parent"); }
}

class Child extends Parent {
	public void whichClass(){  System.out.println("Child"); }
}

class GrandChild extends Child {
	public void whichClass(){  System.out.println("GrandChild"); }
}

public class CastingObjects {

	public static void main(String[] args) {
		Parent parent = new Parent();
		//parent.whichClass();
		
		Parent pChild1 = new Child();
		//parent1.whichClass();
		
		Parent pGChild2 = new GrandChild();
		//parent2.whichClass();
		
		/*
		 * Explicit/Down Casting
		 * 
		 * Must specify cast because it could cause a problem
		 * 
		 * Also, forcing the developer to cast like this ensures 
		 * that the developer makes sure they know what they are doing!
		 * 
		 */
		
		Child child1 = (Child) pChild1; //Good!
		child1.whichClass();
		
		Child child2 = (Child) pGChild2; //Good!
		child2.whichClass();
		
		//GrandChild gchild1 = (GrandChild) parent1; //ClassCastException
		//gchild1.whichClass();
		
		GrandChild gchild2 = (GrandChild) pGChild2; //Good!
		gchild2.whichClass();
	}

}
