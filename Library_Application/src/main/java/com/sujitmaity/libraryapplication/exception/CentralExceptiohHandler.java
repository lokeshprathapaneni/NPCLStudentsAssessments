package com.sujitmaity.libraryapplication.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CentralExceptiohHandler {
	Logger LOGGER= LoggerFactory.getLogger("CentralExceptiohHandler.class");
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(LengthOfTitleException.class)
	public String LOfTitleException(LengthOfTitleException e) {
		System.out.println("Book Title Should be less than 30 Characters ");
		LOGGER.info("LengthOfTitleException");
		return e.getMessage();
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(YearOfPublishException.class)
	public String YOfPublishException(YearOfPublishException e) {
		System.out.println("Year of published should be less than or equal to current year");
		LOGGER.info("YearOfPublishException");
		return e.getMessage();
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BookIdIsNotPresentException.class)
	public String BIdIsNotPresentException(BookIdIsNotPresentException e) {
		System.out.println("Book Id is not present in Database Server");
		LOGGER.info("BookIdIsNotPresentException");
		return e.getMessage();
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BookIdIsInvalid.class)
	public String BIdIsInvalid(BookIdIsInvalid e) {
		System.out.println("Book Id is Mandatory to Save Data in Server");
		LOGGER.info("BookIdIsInvalid");
		return e.getMessage();
	}

}
