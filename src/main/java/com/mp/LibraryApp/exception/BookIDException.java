package com.mp.LibraryApp.exception;

public class BookIDException extends RuntimeException {
	
	public String message;

	public BookIDException(String message) {
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
		return "BookIDException [message=" + message + "]";
	}
	
	

}
