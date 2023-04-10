package com.deutsche.bank.tradingApp.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime timestamp;
	private String error ;
	private String description;
	public ErrorDetails(LocalDateTime timestamp, String error, String description) {
		super();
		this.timestamp = timestamp;
		this.error = error;
		this.description = description;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public String getError() {
		return error;
	}
	public String getDescription() {
		return description;
	}
	
	
}
