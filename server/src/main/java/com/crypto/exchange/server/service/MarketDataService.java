package com.crypto.exchange.server.service;

import com.crypto.exchange.server.client.MessariClient;
import com.crypto.exchange.server.models.domain.marketdata.MarketDataResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class MarketDataService {

    MessariClient messariClient;

    public MarketDataResponse getMarketDataResponse(String assetKey) {
        return messariClient.getMarketData(assetKey.toLowerCase());
    }
}
