package org.npci.libraryapp.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionalHandling {

	@ExceptionHandler(TitleLengthInvalidException.class)
	public String titleIsInvalid(TitleLengthInvalidException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(InvalidPublishYearException.class)
	public String publishYearInvalid(InvalidPublishYearException e) {
		return e.getMessage();
	}
	@ExceptionHandler(BookIdMandatoryException.class)
	public String mandatoryBookId(BookIdMandatoryException e) {
		return e.getMessage();
	}
	@ExceptionHandler(InvalidBookIdException.class)
	public String invalidBookId(InvalidBookIdException e) {
		return e.getMessage();
	}
}
