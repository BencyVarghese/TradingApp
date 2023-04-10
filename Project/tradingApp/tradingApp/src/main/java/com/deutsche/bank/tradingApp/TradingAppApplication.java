package com.deutsche.bank.tradingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Trading API ",
                description = "Trading Application REST API",
                version = "1.0.0"
        )
)
public class TradingAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(TradingAppApplication.class, args);
	}
}
