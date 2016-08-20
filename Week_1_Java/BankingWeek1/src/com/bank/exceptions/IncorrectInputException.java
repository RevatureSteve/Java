package com.bank.exceptions;

public class IncorrectInputException extends Exception {
	
	public IncorrectInputException(){}
	
	public IncorrectInputException(String message){
		super(message);
	}
	
	//Default message
	public IncorrectInputException(Throwable cause){
		super("Incorrect user input", cause);
	}
	
	public IncorrectInputException(String message, Throwable cause){
		super(message, cause);
	}
	
}
