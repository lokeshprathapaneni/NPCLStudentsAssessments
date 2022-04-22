package orgLibrary.Springcore.Prac.LengthTitleException;

public class yearOfPublishException extends RuntimeException {
	private String message;

	public yearOfPublishException(String message) {
		super();
		this.message = message;
	}

	public yearOfPublishException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
