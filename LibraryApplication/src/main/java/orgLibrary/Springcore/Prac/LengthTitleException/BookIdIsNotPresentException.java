package orgLibrary.Springcore.Prac.LengthTitleException;

public class BookIdIsNotPresentException extends RuntimeException{
   private String message;

public BookIdIsNotPresentException(String message) {
	super();
	this.message = message;
}

public BookIdIsNotPresentException() {
	super();
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}
   

}
