package kr.co.dinner41.vo;

public class StoreListByUserViewVO {
	private String storeCategory;
	private String storeName;
	private String storePhoto;
	private double distance;
	private double reviewScore;
	private String menuName;
	
	public StoreListByUserViewVO() {}

	public StoreListByUserViewVO(String storeCategory, String storeName, String storePhoto, double distance,
			double reviewScore, String menuName) {
		super();
		this.storeCategory = storeCategory;
		this.storeName = storeName;
		this.storePhoto = storePhoto;
		this.distance = distance;
		this.reviewScore = reviewScore;
		this.menuName = menuName;
	}

	public String getStoreCategory() {
		return storeCategory;
	}

	public void setStoreCategory(String storeCategory) {
		this.storeCategory = storeCategory;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStorePhoto() {
		return storePhoto;
	}

	public void setStorePhoto(String storePhoto) {
		this.storePhoto = storePhoto;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(double reviewScore) {
		this.reviewScore = reviewScore;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	
	
	
}
