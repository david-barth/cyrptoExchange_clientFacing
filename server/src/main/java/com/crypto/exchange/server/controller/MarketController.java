package com.crypto.exchange.server.controller;

import com.crypto.exchange.server.models.domain.Exchange.ExchangeRequestBody;
import com.crypto.exchange.server.service.ExchangeDataService;
import com.crypto.exchange.server.service.MarketDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/market")
public class MarketController {

    MarketDataService marketDataService;
    ExchangeDataService exchangeDataService;

    @GetMapping("/marketData/{assetKey}")
    public ResponseEntity<?> getMarketData(@PathVariable String assetKey) {
        try {
            return ResponseEntity.ok(marketDataService.getMarketDataResponse(assetKey));
        } catch (Exception exc) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(exc.getMessage());
        }
    }

    @GetMapping("/allExchanges")
    public ResponseEntity<?> getAllExchanges() {
        try {
            return ResponseEntity.ok(exchangeDataService.getAllExchanges());
        } catch (Exception exc) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(exc.getMessage());
        }
    }

    @PostMapping("/someExchanges")
    public ResponseEntity<?> retrieveExchangeSubset(@RequestBody ExchangeRequestBody request) {
        try {
            return ResponseEntity.ok(exchangeDataService.getExchangeSubset(request));
        } catch (Exception exc) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(exc.getMessage());
        }
    }
}
