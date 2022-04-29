package org.usermanagementapp.springcore.prac.userexception;

public class PhoneNoException extends RuntimeException{
	private String message;

	public PhoneNoException(String message) {
		super();
		this.message = message;
	}

	public PhoneNoException() {
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
		return "PhoneNoException [message=" + message + "]";
	}
	

}
