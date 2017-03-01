package com.bits.saas.pojo;

import java.io.Serializable;

public class WorkAround implements Serializable {

	private static final long serialVersionUID = -6805541621191113124L;
	
	private long id;
	private Customer customer;
	private FeatureRequest featureRequest;
	private int upvoteCount;
	private String description;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public FeatureRequest getFeatureRequest() {
		return featureRequest;
	}
	public void setFeatureRequest(FeatureRequest featureRequest) {
		this.featureRequest = featureRequest;
	}
	public int getUpvoteCount() {
		return upvoteCount;
	}
	public void setUpvoteCount(int upvoteCount) {
		this.upvoteCount = upvoteCount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
