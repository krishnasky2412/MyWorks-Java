package com.sky.beans.PaymentManager.PurchaseSuccess;

public class subscriptions_added_context_offers {
	private String duration;
	private String	id;
	private String staticId;
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStaticId() {
		return staticId;
	}
	public void setStaticId(String staticId) {
		this.staticId = staticId;
	}
	@Override
	public String toString() {
		return "Offers [duration=" + duration + ", id=" + id + ", staticId=" + staticId + "]";
	}
}
