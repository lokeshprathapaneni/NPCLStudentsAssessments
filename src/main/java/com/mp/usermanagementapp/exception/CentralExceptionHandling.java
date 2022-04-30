package com.mp.usermanagementapp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus
public class CentralExceptionHandling {
	
	Logger LOGGER=LoggerFactory.getLogger(CentralExceptionHandling.class);
	
	/* Exception method for Minimum Age */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MinimumAgeException.class)
	public String MinimAgeException(MinimumAgeException e) {
		LOGGER.error("Error:{}",e.getMessage());
		return e.getMessage();
		
	}
	
	/* Exception Method for Phone number*/
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(PhoneNumberException.class)
	public String PhoneNoException(PhoneNumberException e) {
		LOGGER.error("Error:{}",e.getMessage());
		return e.getMessage();
		
	}
	
	/*Exception method for email validation*/
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmailException.class)
	public String EmailsException(EmailException e) {
		LOGGER.error("Error:{}",e.getMessage());
		return e.getMessage();
		
	}
	
	
	/*Exception method for checking data present in database */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ClearUserDetails.class)
	public String clearUserDetails(ClearUserDetails e) {
		LOGGER.error("Error:{}",e.getMessage());
		return e.getMessage();
		
	}
	
	/*Exception method for checking Id */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserByIdException.class)
	public String UserByIdException(UserByIdException e) {
		LOGGER.error("Error:{}",e.getMessage());
		return e.getMessage();
	}

}
