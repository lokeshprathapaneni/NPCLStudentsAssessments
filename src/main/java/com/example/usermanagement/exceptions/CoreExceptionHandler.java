package com.example.usermanagement.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CoreExceptionHandler {
	Logger LOG = LoggerFactory.getLogger("CoreExceptionHandler.class");
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AgeException.class)
	public String agenotvalid(AgeException e) {
		LOG.error("User should be of minimum 18 years");
		return e.getMessage();
}

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@ExceptionHandler(InvalidPhoneNumberException.class)
public String phoneNumberIsInvalid(InvalidPhoneNumberException e) {
	LOG.error("Invalid PhoneNumber");
	return e.getMessage();
}

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@ExceptionHandler(InvalidEmailException.class)
public String emailIsInvalid(InvalidEmailException e) {
	LOG.error("Invalid Email ID");
	return e.getMessage();
}

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@ExceptionHandler(UserNotAvailableException.class)
public String unavailable(UserNotAvailableException e) {
	LOG.error("User Not Available");
	return e.getMessage();
}
}
