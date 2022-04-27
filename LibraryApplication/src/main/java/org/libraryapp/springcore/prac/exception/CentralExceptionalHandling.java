package org.libraryapp.springcore.prac.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class CentralExceptionalHandling {
	Logger LOGGER=LoggerFactory.getLogger("CentralExceptionalHandling.class");
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(LengthTitleException.class)
	public String LenTitleException(LengthTitleException e) {
		System.out.println("book title should be less than 30 charecters");
		LOGGER.info("{}LengthTitleException",e.getMessage());
		
		return e.getMessage();
	}
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(YearOfPublishException.class)
	public String YOfPublishException(YearOfPublishException e) {
		System.out.println("year of publish should be less than or equals to current year");
		LOGGER.info("{}YearOfPublishException",e.getMessage());
		return e.getMessage();
	}
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BookIdIsNotPresentException.class)
	public String BIdIsNotPresentException(BookIdIsNotPresentException e) {
		System.out.println("bookId is mandatory");
		LOGGER.info("{}BookIdIsNotPresentException",e.getMessage());
		return e.getMessage();
	}
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler( BookIdIsNotValid.class)
	public String  BIdIsNotValid( BookIdIsNotValid e) {
		System.out.println("bookID doesnt exist in db");
		LOGGER.info("{}BookIdIsNotValid",e.getMessage());
		return e.getMessage();
	}

}

