package com.mp.LibraryApp.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionHandling {

	@ExceptionHandler(TitleLengthExceedException.class)
	public String bookTile(TitleLengthExceedException e) {
		return e.getMessage();
		
	}
	
	@ExceptionHandler(YearOfPublishExceedsException.class)
	public String yearOfPublish(YearOfPublishExceedsException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(BookIDException.class)
	public String bookId(BookIDException e) {
		return e.getMessage();
	}
}
