package org.npci.usermanagement.exceptions;

public class InvalidEmailException extends RuntimeException{

	public InvalidEmailException(String message) {
		super(message);
	}
}
