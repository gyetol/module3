package kr.co.dinner41.command;

public class UserInsertCommand {
	private String eamil;
	private String password;
	private String passwordConfirm;
	private String name;
	private String address;
	private String subAddress;
	private String phone;
	private String type;

	public UserInsertCommand() {}
	
	public UserInsertCommand(String eamil, String password, String passwordConfirm, String name, String address,
			String subAddress, String phone, String type) {
		super();
		this.eamil = eamil;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.name = name;
		this.address = address;
		this.subAddress = subAddress;
		this.phone = phone;
		this.type = type;
	}


	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
