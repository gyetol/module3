package kr.co.dinner41.exception.store;

public abstract class StoreException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public StoreException(String message) {
		super(message);
	}
	
	public void doException() {
		//주문버튼누르는 순간 재고가 떨어지는 예외가 발생했을때, 남아있는 재고 만큼만 주문이 된다든지 하는 정책
	}
}
