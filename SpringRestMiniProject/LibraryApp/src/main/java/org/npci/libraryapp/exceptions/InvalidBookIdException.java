package org.npci.libraryapp.exceptions;

public class InvalidBookIdException extends RuntimeException{

	String message;

	public InvalidBookIdException(String message) {
		
		super(message);	
	}
	
}
