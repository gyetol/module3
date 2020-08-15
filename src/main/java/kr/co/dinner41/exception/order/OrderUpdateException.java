package kr.co.dinner41.exception.order;

public class OrderUpdateException extends OrderException {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "주문을 업데이트하는 도중 오류가 발생하였습니다.";
    public OrderUpdateException(){
        this(MESSAGE);
    }
    public OrderUpdateException(String message) {
        super(message);
    }
}
