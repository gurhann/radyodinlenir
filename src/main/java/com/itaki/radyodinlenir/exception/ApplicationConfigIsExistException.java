package com.itaki.radyodinlenir.exception;

public class ApplicationConfigIsExistException extends Exception{

	private static final long serialVersionUID = 1L;

	public ApplicationConfigIsExistException (String configName) {
		super(String.format("Given name config is exist : [%s]", configName));
	}
}
