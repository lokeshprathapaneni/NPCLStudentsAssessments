package org.npci.libraryapp.exceptions;

public class BookIdMandatoryException extends RuntimeException {

	String message;

	public BookIdMandatoryException(String message) {
		super(message);	
	}
	
}
