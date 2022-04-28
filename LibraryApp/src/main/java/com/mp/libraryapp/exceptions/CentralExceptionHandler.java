package com.mp.libraryapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class CentralExceptionHandler {
	
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(TitleLengthNotAllowedException.class)
	public String titelLenInvalid(TitleLengthNotAllowedException e) {
		System.out.println("in handler message title of the book should be less than 30");
		return e.getMessage();
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(YearInvalidException.class)
	public String yearInvalid(YearInvalidException e) {
		System.out.println("in handler message for year of publish more than current year");
		return e.getMsg();
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@ExceptionHandler(BookIdNotProvidedException.class)
	public String bookIdNull(BookIdNotProvidedException e) {
		System.out.println("in handler message id is mandatory");
		return e.getM();
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BookIDInvalidException.class)
	public String bookIdNull(BookIDInvalidException e) {
		System.out.println("in handler message Book id is invalid");
		return e.getMess();
	}
}
