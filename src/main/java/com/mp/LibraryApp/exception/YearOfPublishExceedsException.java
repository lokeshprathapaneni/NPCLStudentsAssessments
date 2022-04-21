package com.mp.LibraryApp.exception;

public class YearOfPublishExceedsException extends RuntimeException{

	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public YearOfPublishExceedsException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "YearOfPublishExceedsException [message=" + message + "]";
	}
	
	
}
