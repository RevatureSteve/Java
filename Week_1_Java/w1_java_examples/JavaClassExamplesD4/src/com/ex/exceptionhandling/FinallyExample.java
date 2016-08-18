package com.ex.exceptionhandling;

public class FinallyExample {


	public static void main(String[] args) {


		FinallyExample ex = new FinallyExample();

		boolean result = ex.divide();
		System.out.println(result);
	}

	public boolean divide() {
		int num1 = 10;
		int num2 = 5;

		try {
			System.out.println(num1 / num2); //  10/0 Throws ArithemeticException
			return true;

		} catch (ArithmeticException e) {

			System.out.println("in catch! Cant divide my zero!"); //catches and returns false
			return false;

		} finally{
			System.out.println("something to be done before returning"); //Finally will be called BEFORE return false
		}
	}

}
