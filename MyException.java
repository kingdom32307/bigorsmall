package bigorsmall;

public class MyException extends Exception {
	private String code;
	private String message;

	public MyException(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
