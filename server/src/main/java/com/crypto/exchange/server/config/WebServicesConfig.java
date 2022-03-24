package com.crypto.exchange.server.config;

import com.crypto.exchange.server.service.QuoteService;
import com.crypto.exchange.server.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebServicesConfig {

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public WebClient webClient() {
        WebClient webclient = WebClient.create("https://data.messari.io/api");
        return webclient;
    }

    @Bean
    public QuoteService quoteService() {
        return new QuoteService(webClient());
    }
}
