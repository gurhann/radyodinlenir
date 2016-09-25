package com.itaki.radyodinlenir.exception;

public class RadioStationCityNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public RadioStationCityNotFoundException(int id) {
		super(String.format("MusicType not found by given id: [%d]", id));
	}

	public RadioStationCityNotFoundException(String name) {
		super(String.format("MusicType not found by given cleanUrl: [%d]", name));
	}
}
