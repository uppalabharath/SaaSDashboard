package com.bits.saas.exception;

public class ProviderException extends Exception {

	private static final long serialVersionUID = -6727840470015412166L;
	
	public ProviderException() {
		super();
	}
	
	public ProviderException(String message) {
        super(message);
    }
	
    public ProviderException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ProviderException(Throwable cause) {
        super(cause);
    }

}
