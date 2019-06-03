package com.sky.beans.PaymentManager.PurchaseSuccess;

import java.util.Arrays;

public class subscriptions_added_context {
	private String isIncluded;
	private subscriptions_added_context_offers offers[];
	private String paymentType;
	private String staticId;
	private String subscriptionType;
	private String duration;
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}

	private String partner;
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getIsIncluded() {
		return isIncluded;
	}
	public void setIsIncluded(String isIncluded) {
		this.isIncluded = isIncluded;
	}
	public subscriptions_added_context_offers[] getOffers() {
		return offers;
	}
	public void setOffers(subscriptions_added_context_offers[] offers) {
		this.offers = offers;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getStaticId() {
		return staticId;
	}
	public void setStaticId(String staticId) {
		this.staticId = staticId;
	}
	public String getSubscriptionType() {
		return subscriptionType;
	}
	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	
	@Override
	public String toString() {
		return "subscriptions_added_context [isIncluded=" + isIncluded + ", offers=" + Arrays.toString(offers)
				+ ", paymentType=" + paymentType + ", staticId=" + staticId + ", subscriptionType=" + subscriptionType
				+ ", duration=" + duration + "]";
	}
}
