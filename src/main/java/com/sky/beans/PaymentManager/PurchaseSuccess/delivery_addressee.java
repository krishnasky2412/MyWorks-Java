package com.sky.beans.PaymentManager.PurchaseSuccess;

public class delivery_addressee {
	private String title;
	private String lastName;
	private String firstName;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String toString() {
		return "delivery_addressee [title=" + title + ", lastName=" + lastName + ", firstName=" + firstName + "]";
	}
	
	
}
