package com.npci.user_management_app.exception;

@SuppressWarnings("serial")
public class UserNotPresentException extends RuntimeException {

	public UserNotPresentException(String message) {
		super(message);
	}

}
