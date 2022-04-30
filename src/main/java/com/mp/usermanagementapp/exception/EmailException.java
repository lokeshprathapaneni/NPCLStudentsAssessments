package com.mp.usermanagementapp.exception;

public class EmailException extends RuntimeException {

	
	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EmailException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "MinimumAgeException [message=" + message + "]";
	}
}
