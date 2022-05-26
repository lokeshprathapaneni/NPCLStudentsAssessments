package org.usermanagementapp.springcore.prac.userexception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralException {
	Logger LOGGER=LoggerFactory.getLogger(" CentralException.class");
	
	/**
	 * AgeException
	 * when User Age less than 18 years*/
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AgeException.class)
	public String AgeException(AgeException e) {
		
		System.out.println("User should be of minimum 18 years");
		LOGGER.info("{}AgeException",e.getMessage());
		return e.getMessage();
	}
	
	
	/**
	 * PhoneNoException
	 * when PhoneNo size is not equal to 10*/
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(PhoneNoException.class)
	public String PhoneNoException(PhoneNoException e) {
		
		System.out.println("invalid phoneNumber");
		LOGGER.info("{}PhoneNoException",e.getMessage());
		return e.getMessage();
	}
	
	/**
	 * EmailIdException
	 * when User EmailId is not correct*/
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmailIdException.class)
	public String EmailIdException(EmailIdException e) {
		
		System.out.println("invalid EMailId");
		LOGGER.info("{}EmailIdException",e.getMessage());
		return e.getMessage();
	}
	
	/**
	 * UserIdIsNotPresentException
	 * when User Id is not present*/
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler( UserIdIsNotPresentException.class)
	public String  UserIdIsNotPresentException( UserIdIsNotPresentException e) {
		System.out.println("userID doesnt exist in db");
		LOGGER.info("{}UserIdIsNotPresentException",e.getMessage());
		return e.getMessage();
	}
	
	

}
