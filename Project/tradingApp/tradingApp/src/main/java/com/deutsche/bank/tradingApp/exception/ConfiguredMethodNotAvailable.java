package com.deutsche.bank.tradingApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Custom Exception for handling methods which is not configured
 * in trading-application.properties file for given signal
 */
@ResponseStatus(code = HttpStatus.NOT_IMPLEMENTED)
public class ConfiguredMethodNotAvailable extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConfiguredMethodNotAvailable(String message) {
		super(message);
	}

}