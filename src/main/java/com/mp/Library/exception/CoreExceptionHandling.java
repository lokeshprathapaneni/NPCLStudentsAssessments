package com.mp.Library.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestControllerAdvice
public class CoreExceptionHandling {

	Logger LOGGER = LoggerFactory.getLogger("CoreExceptionHandling");
	
	@ExceptionHandler(StringOutOfBoundException.class)
	public String stringIsOutOfBound(StringOutOfBoundException e) {
		LOGGER.error("Book Title should be less than 30 characters.");
		return e.getMessage();
	}

@ExceptionHandler(CheckTitleException.class)
public String invalidBookId(CheckTitleException e) {
	LOGGER.error("Book Id is missing.");
	return e.getMessage();
}

@ExceptionHandler(YearOutOfBoundException.class)
public String wrongYear(YearOutOfBoundException e) {
	LOGGER.error(" Year of Publication cannot exceed Current Year.");
	return e.getMessage();
}
}