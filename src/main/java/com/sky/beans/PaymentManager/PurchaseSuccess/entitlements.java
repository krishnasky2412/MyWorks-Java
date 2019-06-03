package com.sky.beans.PaymentManager.PurchaseSuccess;

public class entitlements {
	
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getProductEventId() {
		return productEventId;
	}
	public void setProductEventId(String productEventId) {
		this.productEventId = productEventId;
	}
	private String startDate;
	private String endDate;
	private String productEventId;
	private String name;
	private String state;
    private String productId;
    private String id;
    private String productStaticId;
	private String billingType;
    public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductStaticId() {
		return productStaticId;
	}
	public void setProductStaticId(String productStaticId) {
		this.productStaticId = productStaticId;
	}
	  @Override
		public String toString() {
			return "Entitlements [name=" + name + ", state=" + state + ", productId=" + productId + ", id=" + id
					+ ", productStaticId=" + productStaticId + ", billingType=" + billingType + "]";
		}

}
