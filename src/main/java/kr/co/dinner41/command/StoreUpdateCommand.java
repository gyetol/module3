package kr.co.dinner41.command;

public class StoreUpdateCommand {
	private String businessNumber;
	private String name;
	private String photo;
	private String category;
	private String address;
	private String subAddress;
	private double latitude;
	private double longitude;
	private String phone;
	private String operateTime;
	private String introduction;
	
	public StoreUpdateCommand() {}

	public StoreUpdateCommand(String businessNumber, String name, String photo, String category, String address,
			String subAddress, double latitude, double longitude, String phone, String operateTime,
			String introduction) {
		super();
		this.businessNumber = businessNumber;
		this.name = name;
		this.photo = photo;
		this.category = category;
		this.address = address;
		this.subAddress = subAddress;
		this.latitude = latitude;
		this.longitude = longitude;
		this.phone = phone;
		this.operateTime = operateTime;
		this.introduction = introduction;
	}

	public String getBusinessNumber() {
		return businessNumber;
	}

	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSubAddress() {
		return subAddress;
	}

	public void setSubAddress(String subAddress) {
		this.subAddress = subAddress;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	

}
