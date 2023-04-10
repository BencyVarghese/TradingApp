package com.deutsche.bank.tradingApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_IMPLEMENTED)
public class ConfiguredMethodNotAvailable extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConfiguredMethodNotAvailable(String message) {
		super(message);
	}

}