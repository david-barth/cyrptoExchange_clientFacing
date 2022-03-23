package com.crypto.exchange.server.service;


import com.crypto.exchange.server.entity.Quote;
import lombok.AllArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;

@AllArgsConstructor
public class QuoteService {


    private WebClient cryptoInfoClient;

    public Quote fetchQuoteInfo(String assetName) {
        cryptoInfoClient.get()
                .uri("/" + assetName)
                .header("x-messari-api-key", "e067e272-c6da-4fc5-b381-ba448cc84187")
                .retrieve();

        return new Quote();
    }
}
