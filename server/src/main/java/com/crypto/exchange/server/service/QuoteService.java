package com.crypto.exchange.server.service;


import com.crypto.exchange.server.entity.Quote;
import lombok.AllArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicReference;

@AllArgsConstructor
public class QuoteService {


    private WebClient cryptoInfoClient;

    public Quote fetchQuoteInfo(String assetName) {
       Mono<Quote> testQuote = cryptoInfoClient.get()
                .uri("/" + assetName)
                .header("x-messari-api-key", "e067e272-c6da-4fc5-b381-ba448cc84187")
                .retrieve()
                .bodyToMono(Quote.class);

       AtomicReference<String> testName = new AtomicReference<>("");
       testQuote.subscribe(quote -> testName.set(quote.getAssetName()));

        return new Quote();
    }
}
