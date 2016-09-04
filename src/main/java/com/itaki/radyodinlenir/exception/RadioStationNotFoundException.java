package com.itaki.radyodinlenir.exception;

public class RadioStationNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public RadioStationNotFoundException(int id) {
		super(String.format("RadioStation not found by given id: [%d]", id));
	}

	public RadioStationNotFoundException(String name) {
		super(String.format("RadioStation not found by given name: [%d]", name));
	}
}
