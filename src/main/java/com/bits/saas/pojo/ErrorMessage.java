package com.bits.saas.pojo;

import java.io.Serializable;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import com.bits.saas.exception.AppException;

public class ErrorMessage implements Serializable{

	private static final long serialVersionUID = 3005653103136800456L;

	int status;
	
	/** application specific error code */
	int code;
	
	/** message describing the error*/
	String message;
		
	/** extra information that might useful for developers */
	String developerMessage;	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	public ErrorMessage(AppException appEx) {
		this.code = appEx.getCode();
		this.status = appEx.getStatus();
		this.message = appEx.getMessage();
		this.developerMessage = appEx.getDeveloperMessage();
	}
	
	public ErrorMessage(NotFoundException notFoundEx) {
		this.status = Response.Status.NOT_FOUND.getStatusCode();
		this.message = notFoundEx.getMessage();
		
	}
	
	public ErrorMessage() {
		super();
	}
}
