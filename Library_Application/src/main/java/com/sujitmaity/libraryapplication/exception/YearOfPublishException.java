package com.sujitmaity.libraryapplication.exception;

public class YearOfPublishException extends RuntimeException{
	private String message;

	public YearOfPublishException(String msg) {
		this.message = message;
	}

	public YearOfPublishException() {
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
		return "YearOfPublishException [message=" + message + "]";
	}
	

}
