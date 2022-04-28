package com.mp.libraryapp.exceptions;

public class TitleLengthNotAllowedException extends RuntimeException {

	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TitleLengthNotAllowedException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "TitleLengthNotAllowedException [message=" + message + "]";
	}
	
}
