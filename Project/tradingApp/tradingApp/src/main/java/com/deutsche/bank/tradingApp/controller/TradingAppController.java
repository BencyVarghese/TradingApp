package com.deutsche.bank.tradingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deutsche.bank.tradingApp.service.SignalHandler;

@RestController
@RequestMapping("/tradingApp")
public class TradingAppController {

	@Autowired
	public SignalHandler signalHandler;

	@PostMapping("/signal/{signal}")
	public String executeSignal(@PathVariable int signal) {
		signalHandler.handleSignal(signal);
		return "signal is processed successfully ";
	}
}
