package com.example.usermanagement.exceptions;

public class UserNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotAvailableException(String message){
		super(message);
	}

}
