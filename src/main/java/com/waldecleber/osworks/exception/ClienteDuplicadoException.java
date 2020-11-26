package com.waldecleber.osworks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ClienteDuplicadoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteDuplicadoException(String msg) {
		super(msg);
	}

}
