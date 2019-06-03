package com.sky.beans.PaymentManager.PurchaseSuccess;

import java.util.Arrays;

public class charges {
	private String tenureNonDiscountedAmountTotal;
	
	private String chargeDelay;
    private String billingType;
    private String staticId;
    private charges_discounts discounts[];
    private String savingAmount;
    private String rate;
    private String pointOfSaleAmount;
    private String amount;
    private String nextRenewalAmount;
    private String fullAmount;
    private String appliedToBusinessId;
    private String appliedToStaticId;
    private String savingPercentage;
    
    public String getTenureNonDiscountedAmountTotal() {
		return tenureNonDiscountedAmountTotal;
	}
	public void setTenureNonDiscountedAmountTotal(String tenureNonDiscountedAmountTotal) {
		this.tenureNonDiscountedAmountTotal = tenureNonDiscountedAmountTotal;
	}
	public String getChargeDelay() {
		return chargeDelay;
	}
	public void setChargeDelay(String chargeDelay) {
		this.chargeDelay = chargeDelay;
	}
	public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}
	public String getStaticId() {
		return staticId;
	}
	public void setStaticId(String staticId) {
		this.staticId = staticId;
	}
	
	public charges_discounts[] getDiscounts() {
		return discounts;
	}
	public void setDiscounts(charges_discounts[] discounts) {
		this.discounts = discounts;
	}
	public String getSavingAmount() {
		return savingAmount;
	}
	public void setSavingAmount(String savingAmount) {
		this.savingAmount = savingAmount;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getPointOfSaleAmount() {
		return pointOfSaleAmount;
	}
	public void setPointOfSaleAmount(String pointOfSaleAmount) {
		this.pointOfSaleAmount = pointOfSaleAmount;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getNextRenewalAmount() {
		return nextRenewalAmount;
	}
	public void setNextRenewalAmount(String nextRenewalAmount) {
		this.nextRenewalAmount = nextRenewalAmount;
	}
	public String getFullAmount() {
		return fullAmount;
	}
	public void setFullAmount(String fullAmount) {
		this.fullAmount = fullAmount;
	}
	public String getAppliedToBusinessId() {
		return appliedToBusinessId;
	}
	public void setAppliedToBusinessId(String appliedToBusinessId) {
		this.appliedToBusinessId = appliedToBusinessId;
	}
	public String getAppliedToStaticId() {
		return appliedToStaticId;
	}
	public void setAppliedToStaticId(String appliedToStaticId) {
		this.appliedToStaticId = appliedToStaticId;
	}
	public String getSavingPercentage() {
		return savingPercentage;
	}
	public void setSavingPercentage(String savingPercentage) {
		this.savingPercentage = savingPercentage;
	}
	@Override
	public String toString() {
		return "Charges [tenureNonDiscountedAmountTotal=" + tenureNonDiscountedAmountTotal + ", chargeDelay="
				+ chargeDelay + ", billingType=" + billingType + ", staticId=" + staticId + ", discounts="
				+ Arrays.toString(discounts) + ", savingAmount=" + savingAmount + ", rate=" + rate
				+ ", pointOfSaleAmount=" + pointOfSaleAmount + ", amount=" + amount + ", nextRenewalAmount="
				+ nextRenewalAmount + ", fullAmount=" + fullAmount + ", appliedToBusinessId=" + appliedToBusinessId
				+ ", appliedToStaticId=" + appliedToStaticId + ", savingPercentage=" + savingPercentage + "]";
	}	
	
}
