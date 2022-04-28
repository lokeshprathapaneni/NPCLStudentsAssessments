package com.mp.libraryapp.exceptions;

public class BookIDInvalidException extends RuntimeException{
	
	String mess;

	
	public BookIDInvalidException(String mess) {
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
		return "BookIDInvalidException [mess=" + mess + "]";
	}
	

}
