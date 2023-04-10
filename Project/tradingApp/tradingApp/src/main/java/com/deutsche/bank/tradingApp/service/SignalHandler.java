package com.deutsche.bank.tradingApp.service;

import org.springframework.stereotype.Component;
/**
 * This is an upcall from our trading system, and we cannot change it.
 */

@Component
public interface SignalHandler {
	void handleSignal(int signal);
}
