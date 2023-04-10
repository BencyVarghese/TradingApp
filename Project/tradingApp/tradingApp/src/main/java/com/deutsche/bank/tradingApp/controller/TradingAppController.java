package com.deutsche.bank.tradingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.deutsche.bank.tradingApp.service.SignalHandler;

@RestController
public class TradingAppController {

	@Autowired
	public SignalHandler signalHandler;

	@GetMapping("/signal/{signal}")
	public String callSingnal(@PathVariable int signal) {
		signalHandler.handleSignal(signal);
		return "signal is processed successfully ";
	}
}
