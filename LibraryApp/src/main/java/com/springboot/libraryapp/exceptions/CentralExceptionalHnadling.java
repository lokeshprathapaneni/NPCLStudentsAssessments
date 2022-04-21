package com.springboot.libraryapp.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionalHnadling {

	@ExceptionHandler(InvalidYearException.class)
	public String yearIsInvalid(InvalidYearException e) {
		return e.getMsg();
	}
	
	@ExceptionHandler(CharacterLengthException.class)
	public String charLength(CharacterLengthException e) {
		return e.getMsg();
	}
	
	@ExceptionHandler(BookIdNotPresentException.class)
	public String idIsMandatory(BookIdNotPresentException e) {
		return e.getMessage();
	}
//	
	@ExceptionHandler(InvalidBookIdException.class)
	public String idIsInvallid(InvalidBookIdException e) {
		return e.getMsg();
	}
}
