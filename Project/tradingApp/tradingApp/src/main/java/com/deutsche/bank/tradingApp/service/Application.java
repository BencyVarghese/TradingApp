package com.deutsche.bank.tradingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deutsche.bank.tradingApp.service.logic.TradeAppService;
@Component
public class Application implements SignalHandler {

	@Autowired
	public TradeAppService tradeAppService;

	@Override
	public void handleSignal(int signal) {

		Worker worker = tradeAppService.getSignalTask(signal);
		worker.dotask();
	}
}
