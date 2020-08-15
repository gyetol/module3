package kr.co.dinner41.exception.order;

public class OrderInsertException extends OrderException {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "주문을 등록하는 중 오류가 발생하였습니다.";
    public OrderInsertException(){
        this(MESSAGE);
    }
    public OrderInsertException(String message) {
        super(message);
    }
}
