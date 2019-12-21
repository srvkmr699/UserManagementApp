package com.sourav.exceptions;

public class EmailAlreadyUsedException extends RuntimeException {

	private static String DEFAULT_MESSAGE = "Email already in use";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailAlreadyUsedException() {
		super(DEFAULT_MESSAGE);
	}

	public EmailAlreadyUsedException(String message) {
		super(message);
	}

}
