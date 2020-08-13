package kr.co.dinner41.exception;

public class UserTypeDeleteFailedException extends UserTypeException {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE="UserTypeDaoImpl의 delete메소드 수행 중 오류 발생";
	public UserTypeDeleteFailedException() {
		this(MESSAGE);
	}
	public UserTypeDeleteFailedException(String message) {
		super(message);
	}
}
