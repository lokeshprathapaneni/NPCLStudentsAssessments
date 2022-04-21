package com.springboot.libraryapp.exceptions;

public class InvalidBookIdException extends RuntimeException{

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "InvalidBookIdException [msg=" + msg + "]";
	}

	public InvalidBookIdException(String msg) {
		super();
		this.msg = msg;
	}
	
}
