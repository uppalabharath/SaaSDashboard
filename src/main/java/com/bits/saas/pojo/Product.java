package com.bits.saas.pojo;

import java.io.Serializable;

public class Product implements Serializable{
	
	private static final long serialVersionUID = -8513335732254865938L;

	private long id;
	
	private String name;
	
	private float revenue;
	
	private float reputation;
	
	private Enterprise enterprise;

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

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public float getRevenue() {
		return revenue;
	}

	public void setRevenue(float revenue) {
		this.revenue = revenue;
	}

	public float getReputation() {
		return reputation;
	}

	public void setReputation(float reputation) {
		this.reputation = reputation;
	}

}
