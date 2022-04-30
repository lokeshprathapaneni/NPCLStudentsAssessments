package org.npci.usermanagement.exceptions;

public class InvalidPhoneNumberException extends RuntimeException{

	public InvalidPhoneNumberException(String message) {
		super(message);
	}
}
