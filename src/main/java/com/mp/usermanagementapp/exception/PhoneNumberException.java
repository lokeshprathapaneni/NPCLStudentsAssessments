package com.mp.usermanagementapp.exception;

public class PhoneNumberException extends RuntimeException {
	
	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PhoneNumberException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "MinimumAgeException [message=" + message + "]";
	}

}
