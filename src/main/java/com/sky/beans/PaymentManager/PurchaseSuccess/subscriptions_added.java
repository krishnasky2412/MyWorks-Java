package com.sky.beans.PaymentManager.PurchaseSuccess;

public class subscriptions_added {
	private String productStaticId;
	private String id;
	private  subscriptions_added_context context;
	private String productId;
	
	public String getProductStaticId() {
		return productStaticId;
	}
	public void setProductStaticId(String productStaticId) {
		this.productStaticId = productStaticId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public subscriptions_added_context getContext() {
		return context;
	}
	public void setContext(subscriptions_added_context context) {
		this.context = context;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	

	@Override
	public String toString() {
		return "subscriptions_added [productStaticId=" + productStaticId + ", id=" + id + ", context=" + context
				+ ", productId=" + productId + "]";
	}


}
