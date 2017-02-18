package com.bits.saas.exception;

public class AppException extends Exception {

	private static final long serialVersionUID = -3619592062785856072L;

	/**
	 * contains redundantly the HTTP status of the response sent back to the
	 * client in case of error, so that the developer does not have to look into
	 * the response headers. If null a default
	 */
	Integer status;

	/** application specific error code */
	int code;

	/** detailed error description for developers */
	String developerMessage;

	/**
	 * 
	 * @param status
	 * @param code
	 * @param message
	 * @param developerMessage
	 * @param link
	 */
	public AppException(int status, int code, String message, String developerMessage) {
		super(message);
		this.status = status;
		this.code = code;
		this.developerMessage = developerMessage;
	}

	public AppException() {
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

}
