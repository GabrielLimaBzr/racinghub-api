package com.application.racinghub.common.infra;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class CustomExceptionResponse {
	
	private String timestamp;
	private int status;
	private String message;
	
	public CustomExceptionResponse(String message, int status){
		this.timestamp = LocalDateTime.now().toString();
        this.message = message;
        this.status = status;
    }

}
