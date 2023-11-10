package com.application.corridahub.comum.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.application.corridahub.comum.domain.exception.ResourceNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ ResourceNotFoundException.class })
	public ResponseEntity<CustomExceptionResponse> handleUserNotFoundException(ResourceNotFoundException exception) {
		CustomExceptionResponse customException = new CustomExceptionResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customException);
	}

}
