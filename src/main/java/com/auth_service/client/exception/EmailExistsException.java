package com.auth_service.client.exception;

@SuppressWarnings("serial")
public class EmailExistsException extends RuntimeException {

	public EmailExistsException(String message) {
		super(message);
	}

}
