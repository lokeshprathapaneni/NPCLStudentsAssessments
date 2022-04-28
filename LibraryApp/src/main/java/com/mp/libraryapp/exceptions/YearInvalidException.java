package com.mp.libraryapp.exceptions;

public class YearInvalidException extends RuntimeException{
	
	String msg;

	public YearInvalidException(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "YearInvalidException [msg=" + msg + "]";
	}



}
