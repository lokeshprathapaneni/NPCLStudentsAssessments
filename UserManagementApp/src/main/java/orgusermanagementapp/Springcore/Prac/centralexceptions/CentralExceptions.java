package orgusermanagementapp.Springcore.Prac.centralexceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class CentralExceptions {
	Logger LOGGER=LoggerFactory.getLogger("CentralExceptions.class");
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AgeException.class)
	public String AgeException(AgeException e) {
		System.out.println("user should be of minimun 18 years");
		LOGGER.info("AgeException{}",e.getMessage());
		
		return e.getMessage();
	}
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(PhoneException.class)
	public String PhoneException(PhoneException e) {
		System.out.println("phone number is invalid");
		LOGGER.info("PhoneException{}",e.getMessage());
		
		return e.getMessage();
	}
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmailIdException.class)
	public String EmailIdException(EmailIdException e) {
		System.out.println("EmailId  is invalid");
		LOGGER.info("EmailIdException{}",e.getMessage());
		
		return e.getMessage();
	}
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserIdIsNotPresentException.class)
	public String UserIdIsNotPresentException(UserIdIsNotPresentException e) {
		System.out.println("userID is not present");
		LOGGER.info("UserIdIsNotPresentException{}",e.getMessage());
		
		return e.getMessage();
	}
	
}
