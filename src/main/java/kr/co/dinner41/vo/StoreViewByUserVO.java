package kr.co.dinner41.vo;

public class StoreViewByUserVO {
	private StoreVO store;
	private MenuVO menu;
	private ReviewVO review;
	
	public StoreViewByUserVO() {}

	public StoreViewByUserVO(StoreVO store, MenuVO menu, ReviewVO review) {
		this.store = store;
		this.menu = menu;
		this.review = review;
	}

	public StoreVO getStore() {
		return store;
	}

	public void setStore(StoreVO store) {
		this.store = store;
	}

	public MenuVO getMenu() {
		return menu;
	}

	public void setMenu(MenuVO menu) {
		this.menu = menu;
	}

	public ReviewVO getReview() {
		return review;
	}

	public void setReview(ReviewVO review) {
		this.review = review;
	}
	
	
	
}
