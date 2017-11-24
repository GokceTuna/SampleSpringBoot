package com.sample.shared.exception;

public class SharedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5016641628972665662L;

	public SharedException() {
		super();
	}

	public SharedException(String message) {
		super(message);
	}

	public SharedException(Throwable cause) {
		super(cause);
	}

	public SharedException(String message, Throwable cause) {
		super(message, cause);
	}

	public SharedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
