package com.deutsche.bank.tradingAppConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@EnableConfigServer
@SpringBootApplication
public class TradingAppConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingAppConfigServerApplication.class, args);
	}

}
