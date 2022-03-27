package com.crypto.exchange.server.service;

import com.crypto.exchange.server.entity.domain.Profile;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class QuoteService {

    private WebClient cryptoInfoWebClient;

    public Profile fetchQuoteInfo(String assetURI) {
        return cryptoInfoWebClient.get()
                .uri(assetURI)
                .retrieve()
                .bodyToMono(Profile.class)
                .block();
    }

}
