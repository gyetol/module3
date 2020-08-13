package kr.co.dinner41.exception;

public abstract class UserTypeException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserTypeException(String message) {
		super(message);
	}
}
