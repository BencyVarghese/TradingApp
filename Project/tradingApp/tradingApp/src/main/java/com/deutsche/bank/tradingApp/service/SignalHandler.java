package com.deutsche.bank.tradingApp.service;

import org.springframework.stereotype.Component;

@Component
public interface SignalHandler {
	void handleSignal(int signal);
}
