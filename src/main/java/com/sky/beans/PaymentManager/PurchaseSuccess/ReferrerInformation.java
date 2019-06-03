package com.sky.beans.PaymentManager.PurchaseSuccess;

public class ReferrerInformation {
	private String purchaseReferrerType;
	private String purchaseReferrerName;
	private String deviceModel;
	private String purchaseReferrerChannel;
	public String getPurchaseReferrerType() {
		return purchaseReferrerType;
	}
	public void setPurchaseReferrerType(String purchaseReferrerType) {
		this.purchaseReferrerType = purchaseReferrerType;
	}
	public String getPurchaseReferrerName() {
		return purchaseReferrerName;
	}
	public void setPurchaseReferrerName(String purchaseReferrerName) {
		this.purchaseReferrerName = purchaseReferrerName;
	}
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	public String getPurchaseReferrerChannel() {
		return purchaseReferrerChannel;
	}
	public void setPurchaseReferrerChannel(String purchaseReferrerChannel) {
		this.purchaseReferrerChannel = purchaseReferrerChannel;
	}

	@Override
	public String toString() {
		return "ReferrerInformation [purchaseReferrerType=" + purchaseReferrerType + ", purchaseReferrerName="
				+ purchaseReferrerName + ", deviceModel=" + deviceModel + ", purchaseReferrerChannel="
				+ purchaseReferrerChannel + "]";
	}
	
}