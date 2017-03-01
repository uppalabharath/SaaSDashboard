package com.bits.saas.pojo;

import java.io.Serializable;

public class CustomerRevenue implements Serializable {
	
	private static final long serialVersionUID = -5875913774454910712L;

	private int month;
	
	private int year;
	
	private float amount;
	
	private Customer customer;

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
