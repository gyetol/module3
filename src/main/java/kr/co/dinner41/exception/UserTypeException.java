package kr.co.dinner41.exception;

public class UserTypeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserTypeException(String message) {
		super(message);
	}

}