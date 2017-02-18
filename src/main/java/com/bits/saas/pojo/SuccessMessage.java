package com.bits.saas.pojo;

import java.io.Serializable;

public class SuccessMessage implements Serializable {

	private static final long serialVersionUID = 6074011397898130362L;
	
	private int status;
	
	private String message;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public SuccessMessage(int status, String message) {
		this.status = status;
		this.message = message;
	}

}
