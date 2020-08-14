package kr.co.dinner41.exception.menu2order;

public class Menu2OrderUpdateException extends Menu2OrderException {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "주문목록을 업데이트하는 도중 오류가 발생하였습니다.";
    public Menu2OrderUpdateException(){
        this(MESSAGE);
    }
    public Menu2OrderUpdateException(String message) {
        super(message);
    }
}
