package com.itaki.radyodinlenir.exception;

public class MusicTypeIsExistException extends Exception{
	private static final long serialVersionUID = 1L;

	public MusicTypeIsExistException (String name) {
		super(String.format("Given name music type is exist : [%s]", name));
	}
}
