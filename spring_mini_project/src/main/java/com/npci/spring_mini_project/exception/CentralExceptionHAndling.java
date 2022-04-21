package com.npci.spring_mini_project.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionHAndling {

	@ExceptionHandler(TitleCheckException.class)
	public String titleCheckException(TitleCheckException e) {
		return e.getMessage();
	}

	@ExceptionHandler(PublishYearException.class)
	public String yearCheckException(PublishYearException e) {
		return e.getMessage();
	}

	@ExceptionHandler(BookIdCheckException.class)
	public String bookIdException(BookIdCheckException e) {
		return e.getMessage();
	}

}
