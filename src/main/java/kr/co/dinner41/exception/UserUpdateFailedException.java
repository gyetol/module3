package kr.co.dinner41.exception;

public class UserUpdateFailedException extends UserException {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE="회원정보를 수정하지 못했습니다.";
	
	public UserUpdateFailedException() {
		this(MESSAGE);
	}
	public UserUpdateFailedException(String message) {
		super(message);
	}

}
