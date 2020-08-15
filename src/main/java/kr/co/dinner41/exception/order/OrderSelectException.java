package kr.co.dinner41.exception.order;

public class OrderSelectException extends OrderException {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "주문내용을 가져오는 도중 오류가 발생하였습니다.";
    public OrderSelectException(){
        this(MESSAGE);
    }
    public OrderSelectException(String message) {
        super(message);
    }
}
