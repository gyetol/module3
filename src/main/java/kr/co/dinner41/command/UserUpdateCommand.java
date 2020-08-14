package kr.co.dinner41.command;

public class UserUpdateCommand {
	private String name;
	private String phone;
	private String address;
	private String subAddress;
	private String newPassword;
	private String newPasswordConfirm;
	
	public UserUpdateCommand() {}

	public UserUpdateCommand(String name, String phone, String address, String subAddress, String newPassword,
			String newPasswordConfirm) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.subAddress = subAddress;
		this.newPassword = newPassword;
		this.newPasswordConfirm = newPasswordConfirm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordConfirm() {
		return newPasswordConfirm;
	}

	public void setNewPasswordConfirm(String newPasswordConfirm) {
		this.newPasswordConfirm = newPasswordConfirm;
	}

}
