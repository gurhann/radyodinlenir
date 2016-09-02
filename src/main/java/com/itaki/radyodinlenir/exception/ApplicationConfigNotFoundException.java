package com.itaki.radyodinlenir.exception;

public class ApplicationConfigNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ApplicationConfigNotFoundException(String configName) {
		super(String.format("Config not found by given name: [%s]", configName));
	}

	public ApplicationConfigNotFoundException(byte id) {
		super(String.format("Config not found by given id: [%d]", id));

	}

}
