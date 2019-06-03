package com.sky.beans.PaymentManager.PurchaseSuccess;

public class vouchers {
	private String voucherCode;
    
	private String primaryProductIds;
	public String getPrimaryProductIds() {
		return primaryProductIds;
	}
	public void setPrimaryProductIds(String primaryProductIds) {
		this.primaryProductIds = primaryProductIds;
	}
	public String getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	
	@Override
	public String toString() {
		return "Vouchers [voucherCode=" + voucherCode + ", primaryProductIds=" + primaryProductIds + "]";
	}
}

