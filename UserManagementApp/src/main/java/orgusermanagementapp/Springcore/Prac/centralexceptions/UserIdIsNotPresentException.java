package orgusermanagementapp.Springcore.Prac.centralexceptions;

public class UserIdIsNotPresentException extends RuntimeException{
	private String message;

	public UserIdIsNotPresentException(String message) {
		super();
		this.message = message;
	}

	public UserIdIsNotPresentException() {
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
		return "UserIdIsNotPresentException [message=" + message + "]";
	}
	
}
