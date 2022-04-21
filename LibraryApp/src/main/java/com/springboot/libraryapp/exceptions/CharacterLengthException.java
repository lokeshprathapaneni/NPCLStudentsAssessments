package com.springboot.libraryapp.exceptions;

public class CharacterLengthException extends RuntimeException{

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public CharacterLengthException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "CharacterLengthException [msg=" + msg + "]";
	}
	
	
}
