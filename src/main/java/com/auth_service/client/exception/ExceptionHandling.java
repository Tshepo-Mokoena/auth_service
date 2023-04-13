package com.auth_service.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.auth_service.json.response.Response;

public class ExceptionHandling extends ResponseEntityExceptionHandler {

	private static final String NOT_ENOUGH_PERMISSION = "You do not have enough permission";
	private static final String INCORRECT_CREDENTIALS = "Email / password incorrect. Please try again";
	private static final String ACCOUNT_DISABLED = "Your account has been disabled. Please contact administration for help";
	public static final String EMAIL_ALREADY_EXISTS = "Email already exists";

	@ExceptionHandler(Exception.class)
	public Response<?> handleException(Exception ex) {
		return Response.builder().status(HttpStatus.INTERNAL_SERVER_ERROR)
				.message("An error occurred while processing the request").build();
	}

	@ExceptionHandler(EmailNotFoundException.class)
	public Response<?> handleEmailNotFoundException(EmailNotFoundException ex) {
		return Response.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message(ex.getMessage()).build();
	}

	@ExceptionHandler(EmailExistsException.class)
	public Response<?> handleEmailExistsException(EmailExistsException ex) {
		return Response.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message(ex.getMessage()).build();
	}

	@ExceptionHandler(AccessDeniedException.class)
	public Response<?> handleAccessDeniedException() {
		return Response.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message(NOT_ENOUGH_PERMISSION).build();
	}

	@ExceptionHandler(DisabledException.class)
	public Response<?> handleDisabledException() {
		return Response.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message(ACCOUNT_DISABLED).build();
	}

	@ExceptionHandler(BadCredentialsException.class)
	public Response<?> handleBadCredentialsException() {
		return Response.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message(INCORRECT_CREDENTIALS).build();
	}

}
