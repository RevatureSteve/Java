package com.ex.reflect;

public class Reflection {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException   {
		
		System.out.println("-------- BEFORE MODIFICATIONS --------");
		String beforeTest = new String("Original");
		System.out.println(beforeTest);
		
		java.lang.reflect.Field valueField = String.class.getDeclaredField("value");
		valueField.setAccessible(true);
		
		valueField.set("Original", "Modified".toCharArray());
		System.out.println("-------- AFTER MODIFICATIONS --------");
		System.out.println(beforeTest);
		System.out.print("Original"); System.out.println(" <-wasn't that a literal?");
		String test = new String("Original");
		System.out.println(test);
		String test2 = new String("Original 2");
		System.out.println(test2);  

	}

}
