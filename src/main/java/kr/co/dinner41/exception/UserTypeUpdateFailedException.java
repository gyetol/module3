package kr.co.dinner41.exception;

public class UserTypeUpdateFailedException extends UserTypeException {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE="UserTypeDaoImpl의 update메서드 수행 중 오류 발생";
	
	public UserTypeUpdateFailedException() {
		this(MESSAGE);
	}
	
	public UserTypeUpdateFailedException(String message) {
		super(message);
	}

}
