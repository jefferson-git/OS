package br.com.os.service.exception;

import lombok.Setter;

@SuppressWarnings("serial")
@Setter
public class MethodArgumentTypeMismatchException extends RuntimeException{

	public MethodArgumentTypeMismatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public MethodArgumentTypeMismatchException(String message) {
		super(message);
	}
}
