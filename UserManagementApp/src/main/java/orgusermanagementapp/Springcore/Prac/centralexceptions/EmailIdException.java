package orgusermanagementapp.Springcore.Prac.centralexceptions;

public class EmailIdException extends RuntimeException {
	private String message;

	public EmailIdException(String message) {
		super();
		this.message = message;
	}

	public EmailIdException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
