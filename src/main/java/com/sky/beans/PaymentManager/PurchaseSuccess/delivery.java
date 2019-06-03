package com.sky.beans.PaymentManager.PurchaseSuccess;

public class delivery {
	private String email;
	private delivery_addressee addressee;
	private delivery_address address;
	private String method;
	private String phone;
	
	
	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public delivery_addressee getAddressee() {
		return addressee;
	}

	public void setAddressee(delivery_addressee addressee) {
		this.addressee = addressee;
	}

	public String getmethod() {
		return method;
	}

	public void setmethod(String method) {
		this.method = method;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}

	

	public delivery_address getAddress() {
		return address;
	}

	public void setAddress(delivery_address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Delivery [email=" + email + ", addressee=" + addressee + ", address=" + address + ", method=" + method
				+ ", phone=" + phone + "]";
	}
}
