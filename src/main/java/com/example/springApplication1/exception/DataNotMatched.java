package com.example.springApplication1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DataNotMatched extends RuntimeException{

	public DataNotMatched(String message) {
		super(message);
	}
}
