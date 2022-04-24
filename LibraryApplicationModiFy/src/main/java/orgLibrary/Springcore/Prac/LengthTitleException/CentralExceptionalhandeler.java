package orgLibrary.Springcore.Prac.LengthTitleException;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import orgLibrary.Springcore.Prac.LengthTitleException.LengthTitleException;

@RestControllerAdvice
public class CentralExceptionalhandeler  {
	Logger LOGGER=LoggerFactory.getLogger("CentralExceptionalhandeler.class");
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(LengthTitleException.class)
	public String LenTitleException(LengthTitleException e) {
		System.out.println("book id should be less than 30 characters");
		LOGGER.info("LengthTitleException{}",e.getMessage());
		
		return e.getMessage();
	}
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(yearOfPublishException.class)
	public String yOfPublishException(yearOfPublishException e) {
		System.out.println("year of publish should be less than current year");
		LOGGER.info("yearOfPublishException{}",e.getMessage());
		return e.getMessage();
		}
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BookIdIsNotPresentException.class)
	public String yeaOfPublishException(BookIdIsNotPresentException e) {
		System.out.println("year of publish should be less than current year");
		LOGGER.info("BookIdIsNotPresentException{}",e.getMessage());
		return e.getMessage();
		}
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BookIdIsNotValid.class)
	public String BooIdIsNotValid(BookIdIsNotValid e) {
		System.out.println("invalid book id");
		LOGGER.info("BookIdIsNotValid{}",e.getMessage());
		return e.getMessage();
		}
	
	
}


