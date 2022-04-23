package org.npci.libraryapp.exceptions;

public class InvalidPublishYearException extends RuntimeException{

	String message;

	public InvalidPublishYearException(String message) {
		super(message);
	}
	
}
