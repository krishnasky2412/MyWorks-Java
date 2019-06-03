package com.sky.beans.PaymentManager.PurchaseSuccess;

public class chargeTotals {
	private chargeTotals_recurring recurring;
	
	private chargeTotals_total total;
	private chargeTotals_nonRecurring nonRecurring;
	public chargeTotals_nonRecurring getNonRecurring() {
		return nonRecurring;
	}
	public void setNonRecurring(chargeTotals_nonRecurring nonRecurring) {
		this.nonRecurring = nonRecurring;
	}
	public chargeTotals_recurring getRecurring() {
		return recurring;
	}
	public void setRecurring(chargeTotals_recurring recurring) {
		this.recurring = recurring;
	}
	public chargeTotals_total getTotal() {
		return total;
	}
	public void setTotal(chargeTotals_total total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "ChargeTotals [recurring=" + recurring + ", total=" + total + ", nonRecurring=" + nonRecurring + "]";
	}	
	
}
