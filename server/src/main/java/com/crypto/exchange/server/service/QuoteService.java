package com.crypto.exchange.server.service;


import com.crypto.exchange.server.entity.Quote;
import lombok.AllArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;



@AllArgsConstructor
public class QuoteService {

    private WebClient cryptoInfoClient;

    public Quote fetchQuoteInfo(String assetName) {
        return cryptoInfoClient.get()
                .uri(assetName)
                .retrieve()
                .bodyToMono(Quote.class) //Mono is a reactive programming based class that asynchronously returns a single instance of the object from the response body.
                .block();  //Await like behavior needs to be implemented in order to ensure that the instance resolves down to the class that it is suposed to be mapped to.
    }
}
