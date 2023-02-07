package com.example.springApplication1.exception;

import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)//404 error
public class UserNotFound extends RuntimeException{

	private String message;
	
	public UserNotFound(String message) {
		super(message);
		this.message=message;
	}
}
