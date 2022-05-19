package orgusermanagementapp.Springcore.Prac.centralexceptions;

public class PhoneException extends RuntimeException{
	private String message;

	public PhoneException(String message) {
		super();
		this.message = message;
	}

	public PhoneException() {
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
		return "PhoneException [message=" + message + "]";
	}
	

}
