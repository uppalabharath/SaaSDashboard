package com.bits.saas.pojo;

import java.io.Serializable;

public class FeatureRequest implements Serializable {

	private static final long serialVersionUID = 8196460628368199819L;
	
	private long id;
	private String subject;
	private String description;
	private int upvoteCount;
	private Customer customer;
	private float impactFactor;
	private String creationDate;
	private boolean freezed;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUpvoteCount() {
		return upvoteCount;
	}
	public void setUpvoteCount(int upvoteCount) {
		this.upvoteCount = upvoteCount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public float getImpactFactor() {
		return impactFactor;
	}
	public void setImpactFactor(float impactFactor) {
		this.impactFactor = impactFactor;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public boolean isFreezed() {
		return freezed;
	}
	public void setFreezed(boolean freezed) {
		this.freezed = freezed;
	}

}
