package kr.co.dinner41.exception;

public class SessionException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE="세션 확인 중에 오류 발생";
	public SessionException() {
		this(MESSAGE);
	}
	public SessionException(String message) {
		super(message);
	}

}
