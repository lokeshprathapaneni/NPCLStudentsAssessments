package org.npci.libraryapp.exceptions;

public class TitleLengthInvalidException extends RuntimeException{

	private String message;

	public TitleLengthInvalidException(String message) {
		super(message);	
	}
	
	
}
