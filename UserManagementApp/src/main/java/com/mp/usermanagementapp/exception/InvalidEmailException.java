package com.mp.usermanagementapp.exception;

public class InvalidEmailException extends RuntimeException{
	
	String m;
	
	

	public InvalidEmailException(String m) {
		super();
		this.m = m;
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	@Override
	public String toString() {
		return "InvalidEmailException [m=" + m + "]";
	}
	
	

}
