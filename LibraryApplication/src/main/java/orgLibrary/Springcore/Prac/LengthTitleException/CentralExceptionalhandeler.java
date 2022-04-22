package orgLibrary.Springcore.Prac.LengthTitleException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import orgLibrary.Springcore.Prac.LengthTitleException.LengthTitleException;

@RestControllerAdvice
public class CentralExceptionalhandeler  {
	@ExceptionHandler(LengthTitleException.class)
	public String LenTitleException(LengthTitleException e) {
		System.out.println("book id should be less than 30 characters");
		return e.getMessage();
	}
	@ExceptionHandler(yearOfPublishException.class)
	public String yOfPublishException(yearOfPublishException e) {
		System.out.println("year of publish should be less than current year");
		return e.getMessage();
		}
	@ExceptionHandler(BookIdIsNotPresentException.class)
	public String yeaOfPublishException(BookIdIsNotPresentException e) {
		System.out.println("year of publish should be less than current year");
		return e.getMessage();
		}
	@ExceptionHandler(BookIdIsNotValid.class)
	public String BooIdIsNotValid(BookIdIsNotValid e) {
		System.out.println("invalid book id");
		return e.getMessage();
		}
	
	
}


