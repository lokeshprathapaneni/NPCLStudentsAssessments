package orgLibraryApp.Springcore.Prac.Exception;

public class BookIdIsNotValid extends RuntimeException {
	
	private String message;

	public BookIdIsNotValid(String message) {
		super();
		this.message = message;
	}

	public BookIdIsNotValid() {
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
		return "BookIdIsNotValid [message=" + message + "]";
	}
	
	

}
