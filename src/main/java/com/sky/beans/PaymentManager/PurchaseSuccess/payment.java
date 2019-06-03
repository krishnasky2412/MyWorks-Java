package com.sky.beans.PaymentManager.PurchaseSuccess;

public class payment {
	
	private String customerReference;
	private String alias;
	private String paymentTransactionId;
	private String lastDigits;
	private String expiryDate;
	private String currency;
	private String paymentProvider;
	private String issuerCountry;
	private String method;
	private String amountAuthorised;
	private String paymentContractType;
	private String signupEmail;
	private String skipPaymentPinCheck;
	private payment_paymentProtectionResult paymentProtectionResult;
	public String getSkipPaymentPinCheck() {
		return skipPaymentPinCheck;
	}
	public void setSkipPaymentPinCheck(String skipPaymentPinCheck) {
		this.skipPaymentPinCheck = skipPaymentPinCheck;
	}

	
	
	
	public payment_paymentProtectionResult getPaymentProtectionResult() {
		return paymentProtectionResult;
	}
	public void setPaymentProtectionResult(payment_paymentProtectionResult paymentProtectionResult) {
		this.paymentProtectionResult = paymentProtectionResult;
	}
	public String getCustomerReference() {
		return customerReference;
	}
	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getPaymentTransactionId() {
		return paymentTransactionId;
	}
	public void setPaymentTransactionId(String paymentTransactionId) {
		this.paymentTransactionId = paymentTransactionId;
	}
	public String getLastDigits() {
		return lastDigits;
	}
	public void setLastDigits(String lastDigits) {
		this.lastDigits = lastDigits;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPaymentProvider() {
		return paymentProvider;
	}
	public void setPaymentProvider(String paymentProvider) {
		this.paymentProvider = paymentProvider;
	}
	public String getIssuerCountry() {
		return issuerCountry;
	}
	public void setIssuerCountry(String issuerCountry) {
		this.issuerCountry = issuerCountry;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getAmountAuthorised() {
		return amountAuthorised;
	}
	public void setAmountAuthorised(String amountAuthorised) {
		this.amountAuthorised = amountAuthorised;
	}
	public String getPaymentContractType() {
		return paymentContractType;
	}
	public void setPaymentContractType(String paymentContractType) {
		this.paymentContractType = paymentContractType;
	}
	public String getSignupEmail() {
		return signupEmail;
	}
	public void setSignupEmail(String signupEmail) {
		this.signupEmail = signupEmail;
	}
	@Override
	public String toString() {
		return "Payment [customerReference=" + customerReference + ", alias=" + alias + ", paymentTransactionId="
				+ paymentTransactionId + ", lastDigits=" + lastDigits + ", expiryDate=" + expiryDate + ", currency="
				+ currency + ", paymentProvider=" + paymentProvider + ", issuerCountry=" + issuerCountry + ", method="
				+ method + ", amountAuthorised=" + amountAuthorised + ", paymentContractType=" + paymentContractType
				+ ", signupEmail=" + signupEmail + ", skipPaymentPinCheck=" + skipPaymentPinCheck
				+ ", paymentProtectionResult=" + paymentProtectionResult + "]";
	}

	
	
}

