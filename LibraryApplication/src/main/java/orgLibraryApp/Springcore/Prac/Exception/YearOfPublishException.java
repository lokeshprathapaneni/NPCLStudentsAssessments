package orgLibraryApp.Springcore.Prac.Exception;

public class YearOfPublishException extends RuntimeException {
	
	private String message;

	public YearOfPublishException(String message) {
		this.message = message;
	}

	public YearOfPublishException() {
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
		return "YearOfPublishException [message=" + message + "]";
	}
	
	
	

}
