package com.mahendra.exceptions;

public class NonExistingAccountException extends RuntimeException{
	
	public NonExistingAccountException(String accNum) {
		super("Account "+accNum+" doesn't exists!");
	}
}
