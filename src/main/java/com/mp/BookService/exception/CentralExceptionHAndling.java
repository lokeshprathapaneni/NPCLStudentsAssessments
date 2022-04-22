package com.mp.BookService.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionHAndling {

	@ExceptionHandler(CheckTitleException.class)
	public String checkTitleException(CheckTitleException e) {
		return e.getMessage();
	}

	@ExceptionHandler(StringOutofBoundException.class)
	public String yearCheckException(StringOutofBoundException e) {
		return e.getMessage();
	}

	@ExceptionHandler(YearOutofBoundException.class)
	public String bookIdException(YearOutofBoundException e) {
		return e.getMessage();
	}

}