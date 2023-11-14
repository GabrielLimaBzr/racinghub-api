package com.application.corridahub.comum.infra;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.application.corridahub.comum.domain.exception.ResourceNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomExceptionResponse> handleUserNotFoundException(ResourceNotFoundException exception) {
		CustomExceptionResponse customException = new CustomExceptionResponse(exception.getMessage(),
				HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customException);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		StringBuilder errorMessage = new StringBuilder("Erro de Validação. Erro(s): ");

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			if (error instanceof FieldError) {
				FieldError fieldError = (FieldError) error;
				errorMessage.append(String.format("[%s - %s], ", fieldError.getField(), error.getDefaultMessage()));
			} else {
				errorMessage.append(String.format("[%s], ", error.getDefaultMessage()));
			}
		});

		String finalErrorMessage = errorMessage.toString().substring(0, errorMessage.length() - 2);

		CustomExceptionResponse customException = new CustomExceptionResponse(finalErrorMessage,
				HttpStatus.BAD_REQUEST.value());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customException);
	}
}
