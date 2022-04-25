package com.npci.libraryapp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionHandling {
	
	Logger LOGGER = LoggerFactory.getLogger("CentralExceptionHandling.class");

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(TitleCheckException.class)
	public String titleCheckException(TitleCheckException e) {
		LOGGER.error("Exception Occured is:{} with message:{}",e.getClass().getSimpleName(),e.getMessage());
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(PublishYearException.class)
	public String yearCheckException(PublishYearException e) {
		LOGGER.error("Exception Occured is:{} with message:{}",e.getClass().getSimpleName(),e.getMessage());
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BookIdCheckException.class)
	public String bookIdException(BookIdCheckException e) {
		LOGGER.error("Exception Occured is:{} with message:{}",e.getClass().getSimpleName(),e.getMessage());
		return e.getMessage();
	}

}
