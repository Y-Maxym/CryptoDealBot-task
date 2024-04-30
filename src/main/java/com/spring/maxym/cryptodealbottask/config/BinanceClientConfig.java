package com.spring.maxym.cryptodealbottask.config;

import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BinanceClientConfig {

    @Bean
    public UMFuturesClientImpl binanceClient() {
        return new UMFuturesClientImpl();
    }
}
