package com.sourav.exceptions;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_MESSAGE = "User does not exist";

	public UserNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public UserNotFoundException(String message) {
		super(message);
	}
}
