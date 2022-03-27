package com.crypto.exchange.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
@PropertySource("classpath:externalAPIkeys.properties")
public class WebServicesConfig {

    @Value("${messari.key}")
    private String messariAPIKey;

    @Bean("messariWebClient")
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://data.messari.io/api")
                .defaultHeader("x-messari-api-key", messariAPIKey)
                .build();
    }
}
