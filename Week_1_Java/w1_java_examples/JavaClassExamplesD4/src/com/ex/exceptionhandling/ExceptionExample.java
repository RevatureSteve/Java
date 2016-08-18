package com.ex.exceptionhandling;

public class ExceptionExample {

	public static void main(String[] args) {

		int res = 0;

		try {

			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);

			res = num1 / num2;
			System.out.println(res);
			
			//int [] temp= {12,23,43,22};

			//System.out.println(temp[4]);
		} catch (ArithmeticException ae) {
			System.out.println("cannot divide by zero");
		
		} catch (ArrayIndexOutOfBoundsException ai) {
			System.out.println("array index is out of range");
		} catch (Exception e) {
			System.out.println("some other exception");
		}
		
		System.out.println("done");
	}

}
