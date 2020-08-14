package kr.co.dinner41.exception;

public class UserSelectFailedException extends UserException {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE="회원정보를 불러오지 못했습니다.";
	
	public UserSelectFailedException() {
		this(MESSAGE);
	}
	
	public UserSelectFailedException(String message) {
		super(message);
	}

}
