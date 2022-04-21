package com.springboot.libraryapp.exceptions;

public class InvalidYearException extends RuntimeException{
	
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "InvalidYearException [msg=" + msg + "]";
	}

	public InvalidYearException(String msg) {
		super();
		this.msg = msg;
	}
	

}
