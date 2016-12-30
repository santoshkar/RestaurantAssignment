package com.rest.exception;

/**
 * Exception class
 * 
 * @author Santosh_Kar
 *
 */
public class RestAssignException extends Exception {

	private static final long serialVersionUID = 1771399548577484250L;

	public RestAssignException() {
		super();
	}

	public RestAssignException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public RestAssignException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestAssignException(String message) {
		super(message);
	}

	public RestAssignException(Throwable cause) {
		super(cause);
	}
	
}
