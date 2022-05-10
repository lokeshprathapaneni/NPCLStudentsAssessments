package com.mp.usermanagementapp.exception;

public class AgeNotAllowedException extends RuntimeException{

	
	String message;
	
	

	public AgeNotAllowedException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AgeNotAllowedException [message=" + message + "]";
	}
	
	
}
