package com.itaki.radyodinlenir.exception;

public class ContactRequestNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	public ContactRequestNotFound(Long id) {
		super(String.format("ContactRequest not found by given id: [%d]", id));
	}
}
