package org.sujitmaity.LibraryApplication.Miniproject.Exception;

public class YearOfPublishException extends RuntimeException{
	private String message;

	public YearOfPublishException(String msg) {
		super();
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
	
	
	

}
