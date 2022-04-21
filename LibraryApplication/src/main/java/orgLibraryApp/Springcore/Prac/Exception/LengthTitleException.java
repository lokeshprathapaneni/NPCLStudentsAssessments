package orgLibraryApp.Springcore.Prac.Exception;

public class LengthTitleException extends RuntimeException{
	
	private String message;

	public LengthTitleException(String message) {
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

	@Override
	public String toString() {
		return "LengthTitleException [message=" + message + "]";
	}

	
	
	
	
	

}
