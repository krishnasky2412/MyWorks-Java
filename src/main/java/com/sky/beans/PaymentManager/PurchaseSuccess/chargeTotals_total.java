package com.sky.beans.PaymentManager.PurchaseSuccess;

public class chargeTotals_total {
	private String nextRenewalAmount;
	
	private String fullAmount;
	private String pointOfSaleAmount;
	
	
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
	public String getPointOfSaleAmount() {
		return pointOfSaleAmount;
	}
	public void setPointOfSaleAmount(String pointOfSaleAmount) {
		this.pointOfSaleAmount = pointOfSaleAmount;
	}
	
	@Override
	public String toString() {
		return "chargeTotals_total [nextRenewalAmount=" + nextRenewalAmount + ", fullAmount=" + fullAmount
				+ ", pointOfSaleAmount=" + pointOfSaleAmount + "]";
	}
}

