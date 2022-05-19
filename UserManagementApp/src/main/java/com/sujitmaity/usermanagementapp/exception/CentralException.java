package com.sujitmaity.usermanagementapp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralException {
	Logger LOGGER=LoggerFactory.getLogger("CentralException.class");
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AgeException.class)
	public String AgeException(AgeException e) {
		System.out.println("User Should be of Minimum of 18 Years");
		LOGGER.info("AgeException",e.getMessage());
		return e.getMessage();
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmailIdInValidException.class)
	public String EmailIdInValidException(EmailIdInValidException e) {
		System.out.println("Invalid EmailId");
		LOGGER.info("EmailIdInValidException",e.getMessage());
		return e.getMessage();
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(PhoneNumberInvalidException.class)
	public String PhoneNumberInvalidException(PhoneNumberInvalidException e) {
		System.out.println("Invalid PhoneNumber");
		LOGGER.info("PhoneNumberInvalidException",e.getMessage());
		return e.getMessage();
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserIdDoesNotExistException.class)
	public String UserIdDoesNotExistException(UserIdDoesNotExistException e) {
		System.out.println("UsesrId DoesNot Exist in Database");
		LOGGER.info("UserIdDoesNotExistException",e.getMessage());
		return e.getMessage();
	}

}
