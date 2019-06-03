package com.sky.beans.PaymentManager.PurchaseSuccess;
public class chargeTotals_nonRecurring {
private String	fullAmount;


private String pointOfSaleAmount;
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
	return "chargeTotals_nonRecurring [fullAmount=" + fullAmount + ", pointOfSaleAmount=" + pointOfSaleAmount + "]";
}
	

}
