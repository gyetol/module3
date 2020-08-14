package kr.co.dinner41.vo;

import java.sql.Timestamp;

public class UserVO {
	private int id;
	private UserTypeVO type;
	private String email;
	private String password;
	private String name;
	private String addresss;
	private String subAddress;
	private double latitude;
	private double longitude;
	private String phone;
	private Timestamp registerDate;
	private Timestamp removeDate;
	
	public UserVO() {}

	public UserVO(int id, UserTypeVO type, String email, String password, String name, String addresss,
			String subAddress, double latitude, double longitude, String phone, Timestamp registerDate,
			Timestamp removeDate) {
		super();
		this.id = id;
		this.type = type;
		this.email = email;
		this.password = password;
		this.name = name;
		this.addresss = addresss;
		this.subAddress = subAddress;
		this.latitude = latitude;
		this.longitude = longitude;
		this.phone = phone;
		this.registerDate = registerDate;
		this.removeDate = removeDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserTypeVO getType() {
		return type;
	}

	public void setType(UserTypeVO type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddresss() {
		return addresss;
	}

	public void setAddresss(String addresss) {
		this.addresss = addresss;
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

	public Timestamp getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public Timestamp getRemoveDAte() {
		return removeDate;
	}

	public void setRemoveDAte(Timestamp removeDAte) {
		this.removeDate = removeDAte;
	}

}
