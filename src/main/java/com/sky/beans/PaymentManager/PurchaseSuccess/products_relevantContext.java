package com.sky.beans.PaymentManager.PurchaseSuccess;

import java.util.Arrays;

public class products_relevantContext {

	private String startDate;
	private String isIncluded;
	private String endDate;
	private String nextRenewalDueDate;
	private String subscriptionType;
	private String staticId;
	private String paymentType;
	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}
	private String partner;
	private products_relevantContext_offers[] offers;
	private subscriptions_added_context_offers offer[];
	 
	private String duration;
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

	public products_relevantContext_offers[] getOffers() {
		return offers;
	}

	public void setOffers(products_relevantContext_offers[] offers) {
		this.offers = offers;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public subscriptions_added_context_offers[] getOffer() {
		return offer;
	}

	public void setOffer(subscriptions_added_context_offers offer[]) {
		this.offer = offer;
	}
	@Override
	public String toString() {
		return "RelevantContext [startDate=" + startDate + ", isIncluded=" + isIncluded + ", endDate=" + endDate
				+ ", nextRenewalDueDate=" + nextRenewalDueDate + ", subscriptionType=" + subscriptionType
				+ ", staticId=" + staticId + ", paymentType=" + paymentType + ", offers=" + offers + ", offer="
				+ Arrays.toString(offer) + ", duration=" + duration + "]";
	}
}
