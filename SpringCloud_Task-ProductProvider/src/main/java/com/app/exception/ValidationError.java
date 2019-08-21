package com.app.exception;

public class ValidationError extends RuntimeException {

	
	private static final long serialVersionUID = -5925942273970967113L;

	public ValidationError(String s) {
		super(s);
	}

}
