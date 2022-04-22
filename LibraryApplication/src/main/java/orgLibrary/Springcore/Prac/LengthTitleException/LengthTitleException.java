package orgLibrary.Springcore.Prac.LengthTitleException;

public class LengthTitleException extends RuntimeException{
    private String message;

	public LengthTitleException(String message) {
		super();
		this.message = message;
	}

	public LengthTitleException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
    
}
