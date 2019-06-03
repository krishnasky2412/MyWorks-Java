package com.sky.beans.PaymentManager.PurchaseSuccess;

import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;


	@SuppressWarnings("serial")
	public class PurchaseSuccess implements SDPKafkaIngestBean, Serializable {
		public String originatingSystem;
		public String activityTimestamp;
	    public String activityType;
	    public String provider;
	    public String providerTerritory;
	    public String householdId;
	    public String proposition;
	    public String requestId;
	    public String deviceType;
	    public String devicePlatform;
	    public String orderId; 
	    public String userAgent;
	    public String partnerId;
	    public String deviceId;
		public String userId;
	    public String  purchaseType;
	    public hardware hardware[];
	    public subscriptions_added_context_offers offers[];
	    public entitlements  entitlements[];
	    public advice advice[];
	    public vouchers vouchers[];
	    public charges charges[];
	    public products products[];
	    public delivery delivery;                          
	    public chargeTotals chargeTotals;
	    public payment payment;
	    public ReferrerInformation referrerInformation;
	   public subscriptions subscriptions;
	// private PurSucc_BillingAddress billingAddress;
	   public String[] segmentType;
	   public String PaymentProtectionAccept;
	   @JsonProperty("paymentProtectionAccept")
	  public String[] getSegmentType() {
		return segmentType;
	}
	public void setSegmentType(String[] segmentType) {
		this.segmentType = segmentType;
	}
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	
 
	    public String getPaymentProtectionAccept() {
		return PaymentProtectionAccept;
	}
	    @JsonProperty("PaymentProtectionAccept")
	public void setPaymentProtectionAccept(String PaymentProtectionAccept) {
		this.PaymentProtectionAccept = PaymentProtectionAccept;
	}
		/*public PurSucc_BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(PurSucc_BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}*/
		public String getDeviceId() {
			return deviceId;
		}
		public void setDeviceId(String deviceId) {
			this.deviceId = deviceId;
		}

	public String getOriginatingSystem() {
			return originatingSystem;
		}
		public void setOriginatingSystem(String originatingSystem) {
			this.originatingSystem = originatingSystem;
		}
		public String getActivityTimestamp() {
			return activityTimestamp;
		}
		public void setActivityTimestamp(String activityTimestamp) {
			this.activityTimestamp = activityTimestamp;
		}
		public String getActivityType() {
			return activityType;
		}
		public void setActivityType(String activityType) {
			this.activityType = activityType;
		}
		public String getProvider() {
			return provider;
		}
		public void setProvider(String provider) {
			this.provider = provider;
		}
		public String getProviderTerritory() {
			return providerTerritory;
		}
		public void setProviderTerritory(String providerTerritory) {
			this.providerTerritory = providerTerritory;
		}
		public String getHouseholdId() {
			return householdId;
		}
		public void setHouseholdId(String householdId) {
			this.householdId = householdId;
		}
		public String getProposition() {
			return proposition;
		}
		public void setProposition(String proposition) {
			this.proposition = proposition;
		}
	    public String getUserId() {
			return userId;
	}
		public void setUserId(String userId) {
		this.userId = userId;
		}

		public String getRequestId() {
			return requestId;
		}
		public void setRequestId(String requestId) {
			this.requestId = requestId;
		}
		public String getDeviceType() {
			return deviceType;
		}
		public void setDeviceType(String deviceType) {
			this.deviceType = deviceType;
		}
		public String getDevicePlatform() {
			return devicePlatform;
		}
		public void setDevicePlatform(String devicePlatform) {
			this.devicePlatform = devicePlatform;
		}
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		public String getUserAgent() {
			return userAgent;
		}
		public void setUserAgent(String userAgent) {
			this.userAgent = userAgent;
		}
		public String getPurchaseType() {
			return purchaseType;
		}
		public void setPurchaseType(String purchaseType) {
			this.purchaseType = purchaseType;
		}
		public hardware[] getHardware() {
			return hardware;
		}
		public void setHardware(hardware[] hardware) {
			this.hardware = hardware;
		}
		public subscriptions_added_context_offers[] getOffers() {
			return offers;
		}
		public void setOffers(subscriptions_added_context_offers[] offers) {
			this.offers = offers;
		}
		public entitlements[] getEntitlements() {
			return entitlements;
		}
		public void setEntitlements(entitlements[] entitlements) {
			this.entitlements = entitlements;
		}
		public advice[] getAdvice() {
			return advice;
		}
		public void setAdvice(advice[] advice) {
			this.advice = advice;
		}
		public vouchers[] getVouchers() {
			return vouchers;
		}
		public void setVouchers(vouchers[] vouchers) {
			this.vouchers = vouchers;
		}
		public charges[] getCharges() {
			return charges;
		}
		public void setCharges(charges[] charges) {
			this.charges = charges;
		}
		public products[] getProducts() {
			return products;
		}
		public void setProducts(products[] products) {
			this.products = products;
		}
		public delivery getDelivery() {
			return delivery;
		}
		public void setDelivery(delivery delivery) {
			this.delivery = delivery;
		}
		
		public chargeTotals getChargeTotals() {
			return chargeTotals;
		}
		public void setChargeTotals(chargeTotals chargeTotals) {
			this.chargeTotals = chargeTotals;
		}
		public payment getPayment() {
			return payment;
		}
		public void setPayment(payment payment) {
			this.payment = payment;
		}
		public ReferrerInformation getReferrerInformation() {
			return referrerInformation;
		}
		public void setReferrerInformation(ReferrerInformation referrerInformation) {
			this.referrerInformation = referrerInformation;
		}
		public subscriptions getSubscriptions() {
			return subscriptions;
		}
		public void setSubscriptions(subscriptions subscriptions) {
			this.subscriptions = subscriptions;
		}
	
		
		@Override
		public String toString() {
			return "PurchaseSuccess [originatingSystem=" + originatingSystem + ", activityTimestamp="
					+ activityTimestamp + ", activityType=" + activityType + ", provider=" + provider
					+ ", providerTerritory=" + providerTerritory + ", householdId=" + householdId + ", proposition="
					+ proposition + ", requestId=" + requestId + ", deviceType=" + deviceType + ", devicePlatform="
					+ devicePlatform + ", orderId=" + orderId + ", userAgent=" + userAgent + ", partnerId=" + partnerId
					+ ", deviceId=" + deviceId + ", userId=" + userId + ", purchaseType=" + purchaseType + ", hardware="
					+ Arrays.toString(hardware) + ", offers=" + Arrays.toString(offers) + ", entitlements="
					+ Arrays.toString(entitlements) + ", advice=" + Arrays.toString(advice) + ", vouchers="
					+ Arrays.toString(vouchers) + ", charges=" + Arrays.toString(charges) + ", products="
					+ Arrays.toString(products) + ", delivery=" + delivery + ", chargeTotals=" + chargeTotals
					+ ", payment=" + payment + ", referrerInformation=" + referrerInformation + ", subscriptions="
					+ subscriptions + ", segmentType="
					+ Arrays.toString(segmentType) + ", PaymentProtectionAccept=" + PaymentProtectionAccept + "]";
		}
		
		public String getPrimaryKey() {
			
			return orderId;
		}
		
      
}
