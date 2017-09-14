package com.libertymutual.goforcode.invoice.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class FlatFeeBillingRecord extends BillingRecord{
	
	@Column(nullable=false)
	private double amount;
	
	public double getTotal() {
		return amount;
	}

	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
    }
}
