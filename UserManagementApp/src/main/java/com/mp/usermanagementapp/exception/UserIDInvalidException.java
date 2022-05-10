package com.mp.usermanagementapp.exception;

public class UserIDInvalidException extends RuntimeException {
	
	String information;

	public UserIDInvalidException(String information) {
		super();
		this.information = information;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@Override
	public String toString() {
		return "UserIDInvalidException [information=" + information + "]";
	}
	
	

}
