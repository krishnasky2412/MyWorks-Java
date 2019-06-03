package com.sky.beans.PaymentManager.PurchaseSuccess;

public class payment_paymentProtectionResult {
	
	private payment_paymentProtectionResult_SecureAuthorisationResult SecureAuthorisationResult;

	public payment_paymentProtectionResult_SecureAuthorisationResult getSecureAuthorisationResult() {
		return SecureAuthorisationResult;
	}

	public void setSecureAuthorisationResult(payment_paymentProtectionResult_SecureAuthorisationResult secureAuthorisationResult) {
		SecureAuthorisationResult = secureAuthorisationResult;
	}

	@Override
	public String toString() {
		return "paymentProtectionResult [SecureAuthorisationResult=" + SecureAuthorisationResult + "]";
	}

	

	

	
}
