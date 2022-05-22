package com.npci.user_management_app.exception;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionHandling {

	Logger logger = LoggerFactory.getLogger("CentralExceptionHandling.class");
	
	private static final String EXCEP_MSG_FORMATION= "Exception Occured is:{} with message:{}";

	@ExceptionHandler(UserAgeException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String ageCheckException(UserAgeException e) {
		logger.error(EXCEP_MSG_FORMATION, e.getClass().getSimpleName(), e.getMessage());
		return e.getMessage();
	}

	@ExceptionHandler(PhoneNumberCheckException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String phoneCheckException(PhoneNumberCheckException e) {
		logger.error(EXCEP_MSG_FORMATION, e.getClass().getSimpleName(), e.getMessage());
		return e.getMessage();
	}

	@ExceptionHandler(EmailIdCheckException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String emailCheckException(EmailIdCheckException e) {
		logger.error(EXCEP_MSG_FORMATION, e.getClass().getSimpleName(), e.getMessage());
		return e.getMessage();
	}

	@ExceptionHandler(UserNotPresentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String userPresentException(UserNotPresentException e) {
		logger.error(EXCEP_MSG_FORMATION, e.getClass().getSimpleName(), e.getMessage());
		return e.getMessage();
	}

	@ExceptionHandler(ParseException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String userPresentException(ParseException e) {
		logger.error(EXCEP_MSG_FORMATION, e.getClass().getSimpleName(), e.getMessage());
		return e.getMessage();
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String userPresentException(Exception e) {
		logger.error(EXCEP_MSG_FORMATION, e.getClass().getSimpleName(), e.getMessage());
		return e.getMessage();
	}

}
