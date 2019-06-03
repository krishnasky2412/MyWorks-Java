package com.sky.beans.PaymentManager.PurchaseSuccess;

public class delivery_address {
	private String addressLine2;
	private String town;
	private String addressLine3;
	private String addressLine1;
	private String postcode;
	private String houseName;
	private String nif;
	private String customsCountryCode;
	private String countryCode;
	private String country;
	private String county;
	private String province;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getCustomsCountryCode() {
		return customsCountryCode;
	}
	public void setCustomsCountryCode(String customsCountryCode) {
		this.customsCountryCode = customsCountryCode;
	}
	
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	@Override
	public String toString() {
		return "delivery_address [addressLine2=" + addressLine2 + ", town=" + town + ", addressLine3=" + addressLine3
				+ ", addressLine1=" + addressLine1 + ", postCode=" + postcode + ", houseName=" + houseName + ", nif="
				+ nif + ", customsCountryCode=" + customsCountryCode + ", countryCode=" + countryCode + ", country="
				+ country + ", county=" + county + ", province=" + province + "]";
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
}

