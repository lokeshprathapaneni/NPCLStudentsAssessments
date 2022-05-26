package org.usermanagementapp.springcore.prac.userexception;

public class AgeException extends RuntimeException {
	private String message;

	public AgeException(String message) {
		super();
		this.message = message;
	}
	

	public AgeException() {
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
		return "AgeException [message=" + message + "]";
	}
	
	
	
	
	

}
