package com.sujitmaity.libraryapplication.exception;

public class LengthOfTitleException extends RuntimeException{
	private String message;

	public LengthOfTitleException(String msg) {
		this.message = message;
	}

	public LengthOfTitleException() {
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
		return "LengthOfTitleException [message=" + message + "]";
	}

}
