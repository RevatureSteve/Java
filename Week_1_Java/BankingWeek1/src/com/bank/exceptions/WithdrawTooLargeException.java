package com.bank.exceptions;

public class WithdrawTooLargeException extends Exception {
	
	public WithdrawTooLargeException(){}
	
	public WithdrawTooLargeException(String message){
		super(message);
	}
	
	public WithdrawTooLargeException(String message, Throwable cause){
		super(message, cause);
	}
	
}
