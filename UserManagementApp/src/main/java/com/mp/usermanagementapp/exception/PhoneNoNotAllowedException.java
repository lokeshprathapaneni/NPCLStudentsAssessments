package com.mp.usermanagementapp.exception;

public class PhoneNoNotAllowedException extends RuntimeException {

	String mess;

	
	public PhoneNoNotAllowedException(String mess) {
		super();
		this.mess = mess;
	}
	
	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}



	@Override
	public String toString() {
		return "InvalidPhoneNoException [mess=" + mess + "]";
	}
	
}
