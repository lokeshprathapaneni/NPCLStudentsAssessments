package com.mp.LibraryApp.exception;

public class TitleLengthExceedException extends RuntimeException {
	
	public String message;

	public TitleLengthExceedException(String message) {
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
		return "TitleLengthExceedException [message=" + message + "]";
	}
	
	

}
