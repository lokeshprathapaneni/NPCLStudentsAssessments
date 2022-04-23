package org.libraryapp.springcore.prac.exception;

public class LengthTitleException extends RuntimeException{
	
	private String message;

	public LengthTitleException(String message) {
		this.message = message;
	}

	public LengthTitleException() {
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
		return "LengthTitleException [message=" + message + "]";
	}

	
	
	
	
	

}
