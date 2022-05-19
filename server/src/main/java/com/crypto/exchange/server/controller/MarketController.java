package com.crypto.exchange.server.controller;


import com.crypto.exchange.server.client.MessariClient;
import com.crypto.exchange.server.models.domain.marketdata.MarketDataResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/market")
public class MarketController {

    MessariClient messariClient;


    @GetMapping("/marketData/{assetKey}")
    public MarketDataResponse getMarketData(@PathVariable String assetKey) {
        return messariClient.getMarketData(assetKey);
    }
}
