package model;

public class User extends Car {
	private String id;
	private String UserFullName;
	private String Username;
	private String UserPassword;
	private String UserPhoneNo;
	private String UserAddress;
	public String level;
	public double duration;
	public double totalPayment;
	public String statusItem;
	public String getId() {
		return id;
	}
	public void setId(String userID) {
		this.id = userID;
	}
	public String getUserFullName() {
		return UserFullName;
	}
	public void setUserFullName(String userFullName) {
		UserFullName = userFullName;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public String getUserPhoneNo() {
		return UserPhoneNo;
	}
	public void setUserPhoneNo(String userPhoneNo) {
		UserPhoneNo = userPhoneNo;
	}
	public String getUserAddress() {
		return UserAddress;
	}
	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public double getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPaymemt(double totalPayment) {
		this.totalPayment = totalPayment;
	}
	public String getStatusItem() {
		return statusItem;
	}
	public void setStatusItem(String statusItem) {
		this.statusItem = statusItem;
	}

}

	