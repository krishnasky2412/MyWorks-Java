package com.sky.beans.PaymentManager.PurchaseSuccess;

import java.util.Arrays;

public class subscriptions_updated_context {
	private String isIncluded;
	
	private String endDate;
	private String paymentType;
	private String nextRenewalDueDate;
	private String subscriptionType;
	private String staticId;
	private String duration;
	private subscriptions_added_context_offers offers[];
	private String startDate;
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getIsIncluded() {
		return isIncluded;
	}
	public void setIsIncluded(String isIncluded) {
		this.isIncluded = isIncluded;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getNextRenewalDueDate() {
		return nextRenewalDueDate;
	}
	public void setNextRenewalDueDate(String nextRenewalDueDate) {
		this.nextRenewalDueDate = nextRenewalDueDate;
	}
	public String getSubscriptionType() {
		return subscriptionType;
	}
	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	public String getStaticId() {
		return staticId;
	}
	public void setStaticId(String staticId) {
		this.staticId = staticId;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public subscriptions_added_context_offers[] getOffers() {
		return offers;
	}
	public void setOffers(subscriptions_added_context_offers[] offers) {
		this.offers = offers;
	}
	@Override
	public String toString() {
		return "Subscriptions_Updated_context [isIncluded=" + isIncluded + ", endDate=" + endDate + ", paymentType="
				+ paymentType + ", nextRenewalDueDate=" + nextRenewalDueDate + ", _subscriptionType="
				+ subscriptionType + ", _staticId=" + staticId + ", duration=" + duration + ", offer="
				+ Arrays.toString(offers) + ", startDate=" + startDate + "]";
	}


}