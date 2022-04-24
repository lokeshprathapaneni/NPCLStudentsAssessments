package org.sujitmaity.LibraryApplication.Miniproject.Exception;

public class BookIdIsInvalid extends RuntimeException{
	private String message;

	public BookIdIsInvalid(String message) {
		super();
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
