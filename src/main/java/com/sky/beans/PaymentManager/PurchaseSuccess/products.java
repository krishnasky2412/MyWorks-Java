package com.sky.beans.PaymentManager.PurchaseSuccess;

public class products {
	private String category;
	private String includedBy;
	private products_relevantContext relevantContext;
	private String staticId;
	private String id;
	private String  quantity;

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIncludedBy() {
		return includedBy;
	}
	public void setIncludedBy(String includedBy) {
		this.includedBy = includedBy;
	}
	public products_relevantContext getRelevantContext() {
		return relevantContext;
	}
	public void setRelevantContext(products_relevantContext relevantContext) {
		this.relevantContext = relevantContext;
	}
	public String getStaticId() {
		return staticId;
	}
	public void setStaticId(String staticId) {
		this.staticId = staticId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Products [category=" + category + ", includedBy=" + includedBy + ", relevantContext=" + relevantContext
				+ ", staticId=" + staticId + ", id=" + id + ", quantity=" + quantity + "]";
	}

}
