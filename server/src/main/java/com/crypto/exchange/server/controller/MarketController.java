package com.crypto.exchange.server.controller;


import com.crypto.exchange.server.models.domain.marketdata.MarketData;
import com.crypto.exchange.server.service.MarketDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/market")
public class MarketController {

    MarketDataService marketDataService;

    @GetMapping("/marketData/{assetKey}")
    public MarketData getMarketData(@PathVariable String assetKey) {
        return marketDataService.getMarketDataResponse(assetKey);
    }
}
