package com.crypto.exchange.server.controller;

import com.crypto.exchange.server.entity.domain.Profile;
import com.crypto.exchange.server.service.QuoteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class QuoteController {

    private QuoteService quoteService;

    @GetMapping("getProfile/{assetName}")
    public Profile getAssetQuote(@PathVariable String assetName) {
        return quoteService.fetchQuoteInfo("/v2/assets/btc/profile");
    }

}
