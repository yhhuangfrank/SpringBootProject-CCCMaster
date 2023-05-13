package com.ispan.CCCMaster.model.dto;

public class CustomerCheckRequest {

	private String email;
	private String name;
	private String phoneNumber;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "CustomerCheckRequest [email=" + email + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
