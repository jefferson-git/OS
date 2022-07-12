package br.com.os.service.exception;

import lombok.Setter;

@SuppressWarnings("serial")
@Setter
public class DataIntegrityViolationException extends RuntimeException{

	public DataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegrityViolationException(String message) {
		super(message);
	}
}
