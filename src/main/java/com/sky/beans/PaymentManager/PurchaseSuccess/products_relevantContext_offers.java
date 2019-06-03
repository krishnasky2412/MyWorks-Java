package com.sky.beans.PaymentManager.PurchaseSuccess;

public class products_relevantContext_offers {
	
	private String	staticId;
	private String	id    ;
private String	duration;
public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
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
@Override
public String toString() {
	return "relevantContextOffers [staticId=" + staticId + ", id=" + id + ", duration=" + duration + "]";
}

}
