package com.sky.beans.PaymentManager.PurchaseSuccess;

public class charges_discounts {
	
	private String staticId;
	private String parentOffer;
    private String businessId;
    private String value;
    private String deferred;
    private String duration; 
    private String type;
    public String getStaticId() {
		return staticId;
	}
	public void setStaticId(String staticId) {
		this.staticId = staticId;
	}
	public String getParentOffer() {
		return parentOffer;
	}
	public void setParentOffer(String parentOffer) {
		this.parentOffer = parentOffer;
	}
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getDeferred() {
		return deferred;
	}
	public void setDeferred(String deferred) {
		this.deferred = deferred;
	}
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Discounts [staticId=" + staticId + ", parentOffer=" + parentOffer + ", businessId=" + businessId
				+ ", value=" + value + ", deferred=" + deferred + ", duration=" + duration + ", type=" + type + "]";
	}
}
