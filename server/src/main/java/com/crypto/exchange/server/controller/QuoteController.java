package com.crypto.exchange.server.controller;

import com.crypto.exchange.server.entity.Quote;
import com.crypto.exchange.server.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("getQuote/{assetName}")
    public Quote getAssetQuote(@PathVariable String assetName) {
        return quoteService.fetchQuoteInfo("/v1/assets/btc/metrics");
    }

}
