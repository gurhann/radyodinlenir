package com.itaki.radyodinlenir.exception;

public class SearchTermsNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchTermsNotFoundException(int id) {
		super(String.format("Search Term not found by given id: [%d]", id));
	}
}
