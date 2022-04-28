package com.mp.libraryapp.exceptions;

public class BookIdNotProvidedException extends RuntimeException {

	String m;

	public BookIdNotProvidedException() {
		super();
	}
	public BookIdNotProvidedException(String m) {
		
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
		return "BookIdNotProvidedException [m=" + m + "]";
	}


	
}
