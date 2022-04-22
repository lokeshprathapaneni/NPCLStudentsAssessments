package com.mp.BookService.exception;

public class YearOutofBoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;


public YearOutofBoundException(String message) {
	super(message);

}
}