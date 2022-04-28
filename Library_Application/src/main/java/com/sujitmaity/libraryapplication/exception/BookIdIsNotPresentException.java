package com.sujitmaity.libraryapplication.exception;

public class BookIdIsNotPresentException extends RuntimeException{
	private String message;

	public BookIdIsNotPresentException(String message) {
		this.message = message;
	}

	public BookIdIsNotPresentException() {
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
		return "BookIdIsNotPresentException [message=" + message + "]";
	}
	

}
