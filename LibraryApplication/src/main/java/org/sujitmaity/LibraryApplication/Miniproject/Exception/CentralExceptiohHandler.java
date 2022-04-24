package org.sujitmaity.LibraryApplication.Miniproject.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptiohHandler {

	Logger LOGGER= LoggerFactory.getLogger("CentralExceptiohHandler");
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(LengthOfTitleException.class)
	public String LengthOfTitleException(LengthOfTitleException e) {
		System.out.println("Book Title Should Less Than 30 Characters ");
		LOGGER.info("LengthOfTitleException");
		return e.getMessage();
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(YearOfPublishException.class)
	public String YearOfPublishException(YearOfPublishException e) {
		System.out.println("year of publish should be less than or equals to current year");
		LOGGER.info("YearOfPublishException");
		return e.getMessage();
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BookIdIsNotPresentException.class)
	public String BookIdIsNotPresentException(BookIdIsNotPresentException e) {
		System.out.println("BookIdIsNotPresentException BookId Mandatory");
		LOGGER.info("BookIdIsNotPresentException");
		return e.getMessage();
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BookIdIsInvalid.class)
	public String BookIdIsInvalid(BookIdIsInvalid e) {
		System.out.println("BookIdIsInvalid Doesnt Exist in DataBase");
		LOGGER.info("BookIdIsInvalid");
		return e.getMessage();
	}
}
