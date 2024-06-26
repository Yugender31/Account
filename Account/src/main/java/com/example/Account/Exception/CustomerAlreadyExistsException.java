package com.example.Account.Exception;

public class CustomerAlreadyExistsException extends RuntimeException {
	
	public CustomerAlreadyExistsException(String st) {
		super(st);
	}

}
