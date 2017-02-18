package com.bits.saas.exception;

public class ServiceException extends Exception {
	
	private static final long serialVersionUID = 3581073164170231443L;

	public ServiceException() {
		super();
	}
	
	public ServiceException(String message) {
        super(message);
    }
	
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ServiceException(Throwable cause) {
        super(cause);
    }

}