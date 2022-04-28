package com.sujitmaity.libraryapplication.exception;

public class BookIdIsInvalid extends RuntimeException{
	private String message;

	public BookIdIsInvalid(String message) {
		
		this.message = message;
	}

	public BookIdIsInvalid() {
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
		return "BookIdIsInvalid [message=" + message + "]";
	}
	

}
