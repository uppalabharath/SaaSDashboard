package com.bits.saas.exception;

public class DaoException extends Exception {

	private static final long serialVersionUID = 4151365600117695219L;
	
	public DaoException() {
		super();
	}
	
	public DaoException(String message) {
        super(message);
    }
	
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public DaoException(Throwable cause) {
        super(cause);
    }

}
