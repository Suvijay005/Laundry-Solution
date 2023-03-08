package com.app.custom_exceptions;

public class UserAlreadyExistsException extends RuntimeException {

	public UserAlreadyExistsException(String msg) {
		super(msg);
	}
	
}
