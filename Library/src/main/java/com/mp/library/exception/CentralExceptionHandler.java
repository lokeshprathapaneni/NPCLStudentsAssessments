package com.mp.library.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionHandler {
	
	Logger LOGGER = LoggerFactory.getLogger("CentralExceptionHandler.class");

	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(StringOutOfBoundException.class)
	public String stringIsOutOfBound(StringOutOfBoundException e) {
		LOGGER.error("Book Title should be less than 30 characters.");
		return e.getMessage();
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NullBookIdException.class)
	public String invalidBookId(NullBookIdException e) {
		LOGGER.error("Book Id is not Present.");
		return e.getMessage();
	}
	

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(YearOutOfBoundException.class)
	public String wrongYear(YearOutOfBoundException e) {
		LOGGER.error("Publishing Year cannot be greater than Current Year.");
		return e.getMessage();
	}
}
