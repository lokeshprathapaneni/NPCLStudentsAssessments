package com.npci.spring_mini_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionHAndling {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(TitleCheckException.class)
	public String titleCheckException(TitleCheckException e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(PublishYearException.class)
	public String yearCheckException(PublishYearException e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BookIdCheckException.class)
	public String bookIdException(BookIdCheckException e) {
		return e.getMessage();
	}

}
