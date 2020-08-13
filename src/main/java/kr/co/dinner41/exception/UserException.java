package kr.co.dinner41.exception;


public abstract class UserException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserException(String message) {
		super(message);
	}

}
