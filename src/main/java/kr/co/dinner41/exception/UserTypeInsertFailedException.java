package kr.co.dinner41.exception;

public class UserTypeInsertFailedException extends UserTypeException {
	private static final long serialVersionUID = 1L;
	private static String MESSAGE="user_types 테이블에 insert하다가 오류 발생";
	
	public UserTypeInsertFailedException() {
		this(MESSAGE);
	}
	public UserTypeInsertFailedException(String message) {
		super(MESSAGE);
	}
}
