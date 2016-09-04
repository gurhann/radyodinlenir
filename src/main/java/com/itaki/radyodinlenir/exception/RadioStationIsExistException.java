package com.itaki.radyodinlenir.exception;

public class RadioStationIsExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public RadioStationIsExistException(String name) {
		super(String.format("Given radio station is exist name: [%s]", name));
	}

}
