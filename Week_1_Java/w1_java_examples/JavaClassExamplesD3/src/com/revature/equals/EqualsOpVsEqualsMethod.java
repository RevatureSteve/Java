package com.revature.equals;

public class EqualsOpVsEqualsMethod {

	public static void main(String[] args) {

		/*
		 *  == works fine for primitives
		 */
		int x = 5;
		int y = 5;
		int z = 6;
		
		if( x == y){
			System.out.println( "x == y");
		}else{
			System.out.println( " x != y");
		}
		
		if( x == z){
			System.out.println( "x == z");
		}else{
			System.out.println( " x != z");
		}
		
		System.out.println(); //extra line
		String str1 = "dog";
		String str2 = "dog";
		String str3 = "cat";
		String str4 = new String("cat");
		
		if(str1 == str2){
			System.out.println("Str1 == Str2");
		}else{
			System.out.println("Str1 != Str2");
		}
		
		if(str1 == str3){
			System.out.println("Str1 == Str3");
		}else{
			System.out.println("Str1 != Str3");
		}
		
		if(str3.equals(str4)){
			System.out.println("Str3 == Str4");
		}else{
			System.out.println("Str3 != Str4");
		}
				
	}

}
