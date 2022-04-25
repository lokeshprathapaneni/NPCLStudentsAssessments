package com.mp.LibraryApp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus
public class CentralExceptionHandling {
	
	Logger LOGGER =LoggerFactory.getLogger(CentralExceptionHandling.class);
    
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(TitleLengthExceedException.class)
	public String bookTile(TitleLengthExceedException e) {
		LOGGER.error("Error:{}",e.getMessage());
		return e.getMessage();
		
	}
	
	@ExceptionHandler(YearOfPublishExceedsException.class)
	public String yearOfPublish(YearOfPublishExceedsException e) {
		LOGGER.error("Error:{}",e.getMessage());
		return e.getMessage();
	}
	
	@ExceptionHandler(BookIDException.class)
	public String bookId(BookIDException e) {
		LOGGER.error("Error:{}",e.getMessage());
		return e.getMessage();
	}
}
