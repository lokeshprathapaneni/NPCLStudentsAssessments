package orgLibraryApp.Springcore.Prac.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import orgLibraryApp.Springcore.Prac.Exception.LengthTitleException;

@RestControllerAdvice
public class CentralExceptionalHandling {
	@ExceptionHandler(LengthTitleException.class)
	public String LenTitleException(LengthTitleException e) {
		System.out.println("book title should be less than 30 charecters");
		return e.getMessage();
	}
	
	@ExceptionHandler(YearOfPublishException.class)
	public String YOfPublishException(YearOfPublishException e) {
		System.out.println("year of publish should be less than or equals to current year");
		return e.getMessage();
	}
	
	@ExceptionHandler(BookIdIsNotPresentException.class)
	public String BIdIsNotPresentException(BookIdIsNotPresentException e) {
		System.out.println("bookId is mandatory");
		return e.getMessage();
	}
	
	@ExceptionHandler( BookIdIsNotValid.class)
	public String  BIdIsNotValid( BookIdIsNotValid e) {
		System.out.println("bookID doesnt exist in db");
		return e.getMessage();
	}

}
