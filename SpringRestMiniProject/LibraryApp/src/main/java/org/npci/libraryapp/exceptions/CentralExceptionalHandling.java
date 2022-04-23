package org.npci.libraryapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionalHandling {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(TitleLengthInvalidException.class)
	public String titleIsInvalid(TitleLengthInvalidException e) {
		return e.getMessage();
	}
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPublishYearException.class)
	public String publishYearInvalid(InvalidPublishYearException e) {
		return e.getMessage();
	}
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BookIdMandatoryException.class)
	public String mandatoryBookId(BookIdMandatoryException e) {
		return e.getMessage();
	}
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidBookIdException.class)
	public String invalidBookId(InvalidBookIdException e) {
		return e.getMessage();
	}
}
