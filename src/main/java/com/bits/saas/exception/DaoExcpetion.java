package com.bits.saas.exception;

public class DaoExcpetion extends Exception {

	private static final long serialVersionUID = 4151365600117695219L;
	
	public DaoExcpetion() {
		super();
	}
	
	public DaoExcpetion(String message) {
        super(message);
    }
	
    public DaoExcpetion(String message, Throwable cause) {
        super(message, cause);
    }
    
    public DaoExcpetion(Throwable cause) {
        super(cause);
    }

}
