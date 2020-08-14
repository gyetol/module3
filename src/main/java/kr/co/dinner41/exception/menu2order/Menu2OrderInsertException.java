package kr.co.dinner41.exception.menu2order;

public class Menu2OrderInsertException extends Menu2OrderException {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "주문목록을 등록하는 중 오류가 발생하였습니다.";
    public Menu2OrderInsertException(){
        this(MESSAGE);
    }
    public Menu2OrderInsertException(String message) {
        super(message);
    }
}
