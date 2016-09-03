package com.itaki.radyodinlenir.exception;

public class MusicTypeNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public MusicTypeNotFoundException(int id) {
		super(String.format("MusicType not found by given id: [%d]", id));
	}
	
	public MusicTypeNotFoundException(String name) {
		super(String.format("MusicType not found by given name: [%d]", name));
	}
}
