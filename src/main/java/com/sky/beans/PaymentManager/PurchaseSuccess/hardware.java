package com.sky.beans.PaymentManager.PurchaseSuccess;

public class hardware {

	private String productStaticId;
	private String quantity;
	private String productId;
	private String	deliveryCode;
	public String getDeliveryCode() {
		return deliveryCode;
	}
	public void setDeliveryCode(String deliveryCode) {
		this.deliveryCode = deliveryCode;
	}
	public String getProductStaticId() {
		return productStaticId;
	}
	public void setProductStaticId(String productStaticId) {
		this.productStaticId = productStaticId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}	
	@Override
	public String toString() {
		return "Hardware [productStaticId=" + productStaticId + ", quantity=" + quantity + ", productId=" + productId
				+ ", deliveryCode=" + deliveryCode + "]";
	}
}
