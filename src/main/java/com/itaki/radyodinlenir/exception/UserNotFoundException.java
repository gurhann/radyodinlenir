package com.itaki.radyodinlenir.exception;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String userName) {
		super(String.format("User not found by given username: [%s]", userName));
	}
}
