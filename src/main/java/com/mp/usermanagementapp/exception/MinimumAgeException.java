package com.mp.usermanagementapp.exception;

public class MinimumAgeException extends RuntimeException {

	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MinimumAgeException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "MinimumAgeException [message=" + message + "]";
	}
	
}
