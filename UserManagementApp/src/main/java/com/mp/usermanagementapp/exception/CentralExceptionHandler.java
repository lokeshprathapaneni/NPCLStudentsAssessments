package com.mp.usermanagementapp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CentralExceptionHandler {
	
	Logger LOGGER = LoggerFactory.getLogger("CentralExceptionHandler.class");

	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(AgeNotAllowedException.class)
	public String AgeInvalid(AgeNotAllowedException e) {
		LOGGER.error("in handler message User should be of minimum 18 years");
		return e.getMessage();
}
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(PhoneNoNotAllowedException.class)
	public String InvalidPhoneNo(PhoneNoNotAllowedException e) {
		LOGGER.error("in handler message Invalid Phone number");
		return e.getMess();
	}
	
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(InvalidEmailException.class)
	public String InvalidEmail(InvalidEmailException e) {
		LOGGER.error("in handler message Invalid Email");
		return e.getM();
	}
	
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(UserIDInvalidException.class)
	public String InvalidUserId(UserIDInvalidException e) {
		LOGGER.error("in handler message user Id doesn't exist");
		return e.getInformation();
	}
}
