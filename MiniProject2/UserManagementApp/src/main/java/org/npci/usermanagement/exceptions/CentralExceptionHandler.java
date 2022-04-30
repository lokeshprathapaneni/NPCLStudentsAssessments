package org.npci.usermanagement.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionHandler {

	Logger LOGGER = LoggerFactory.getLogger("CentralExceptionHandler.class");
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidAgeException.class)
	public String ageIsInvalid(InvalidAgeException e) {
		LOGGER.error("InvalidAgeException occured");
		return e.getMessage();
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPhoneNumberException.class)
	public String phoneNumberIsInvalid(InvalidPhoneNumberException e) {
		LOGGER.error("InvalidPhoneNumberException occured");
		return e.getMessage();
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidEmailException.class)
	public String emailIsInvalid(InvalidEmailException e) {
		LOGGER.error("InvalidEmailException occured");
		return e.getMessage();
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserNotAvailableException.class)
	public String unavailable(UserNotAvailableException e) {
		LOGGER.error("UserNotAvailableException occured");
		return e.getMessage();
	}
}
