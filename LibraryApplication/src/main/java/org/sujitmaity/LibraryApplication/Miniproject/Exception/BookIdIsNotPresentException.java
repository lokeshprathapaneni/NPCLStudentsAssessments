package org.sujitmaity.LibraryApplication.Miniproject.Exception;

public class BookIdIsNotPresentException extends RuntimeException{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BookIdIsNotPresentException(String message) {
		super();
		this.message = message;
	}

	public BookIdIsNotPresentException() {
		super();
	}

	@Override
	public String toString() {
		return "BookIdIsNotPresentException [message=" + message + "]";
	}
	

}
