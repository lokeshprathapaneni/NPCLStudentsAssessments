package org.ekartapp.springcore.prac.exception;

public class PasswordException extends RuntimeException{
	
	private String message;

	public PasswordException(String message) {
		super();
		this.message = message;
	}

	public PasswordException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "PasswordException [message=" + message + "]";
	}
	
	
	
	

}
