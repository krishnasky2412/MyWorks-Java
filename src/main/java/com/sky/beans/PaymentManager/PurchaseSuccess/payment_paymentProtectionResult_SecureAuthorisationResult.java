package com.sky.beans.PaymentManager.PurchaseSuccess;

public class payment_paymentProtectionResult_SecureAuthorisationResult {

	private String md;
	
	private String paResponse;
	private String orderId;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getMd() {
		return md;
	}
	public void setMd(String md) {
		this.md = md;
	}
	public String getPaResponse() {
		return paResponse;
	}
	public void setPaResponse(String paResponse) {
		this.paResponse = paResponse;
	}
	@Override
	public String toString() {
		return "SecureAuthorisationResult [md=" + md + ", paResponse=" + paResponse + ", orderId=" + orderId + "]";
	}
	
	
	

}
