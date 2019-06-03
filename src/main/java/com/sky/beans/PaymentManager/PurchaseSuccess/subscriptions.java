package com.sky.beans.PaymentManager.PurchaseSuccess;

import java.util.Arrays;

public class subscriptions {
	
	private subscriptions_updated updated[];
	

	private subscriptions_added added[];

	public subscriptions_updated[] getUpdated() {
		return updated;
	}

	public void setUpdated(subscriptions_updated[] updated) {
		this.updated = updated;
	}

	public subscriptions_added[] getAdded() {
		return added;
	}

	public void setAdded(subscriptions_added[] added) {
		this.added = added;
	}


	@Override
	public String toString() {
		return "Subscriptions [updated=" + Arrays.toString(updated) + ", added=" + Arrays.toString(added) + "]";
	}
}
