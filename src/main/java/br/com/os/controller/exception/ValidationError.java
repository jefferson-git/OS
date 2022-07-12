package br.com.os.controller.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor @Getter
public class ValidationError extends StandardError {

	private List<FieldMessenger> errors = new ArrayList<>();	
	
	public void AddErrors(String fieldName, String message) {
		this.errors.add(new FieldMessenger(fieldName, message));
	}

	public ValidationError(Long timestamp, Integer status, String mensage) {
		super(timestamp, status, mensage);
	}		
}
