package com.bits.saas.pojo;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = -1265171215465652511L;
	
	private long id;
	
	private String name;
	
	private String email;
	
	private float reputation;
	
	private float revenue;

	private Product product;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getReputation() {
		return reputation;
	}

	public void setReputation(float reputation) {
		this.reputation = reputation;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public float getRevenue() {
		return revenue;
	}

	public void setRevenue(float revenue) {
		this.revenue = revenue;
	}

}
