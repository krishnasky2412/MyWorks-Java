package com.sky.beans.PaymentManager.PurchaseSuccess;

public class chargeTotals_recurring {
	private String fullAmount;
	private String pointOfSaleAmount;
	private String nextRenewalAmount;
	public String getNextRenewalAmount() {
		return nextRenewalAmount;
	}
	public void setNextRenewalAmount(String nextRenewalAmount) {
		this.nextRenewalAmount = nextRenewalAmount;
	}
	public String getfullAmount() {
		return fullAmount;
	}
	public void setfullAmount(String fullAmount) {
		this.fullAmount = fullAmount;
	}
	public String getPointOfSaleAmount() {
		return pointOfSaleAmount;
	}
	public void setPointOfSaleAmount(String pointOfSaleAmount) {
		this.pointOfSaleAmount = pointOfSaleAmount;
	}
	
	@Override
	public String toString() {
		return "chargeTotals_recurring [fullAmount=" + fullAmount + ", pointOfSaleAmount=" + pointOfSaleAmount
				+ ", nextRenewalAmount=" + nextRenewalAmount + "]";
	}
}
