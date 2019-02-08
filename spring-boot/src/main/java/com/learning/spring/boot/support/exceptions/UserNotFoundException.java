package com.learning.spring.boot.support.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	static final long serialVersionUID = -597666446225425218L;

	public UserNotFoundException(String message) {
		super(message);
	}
	
    //Supresses the trace
	@Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
