package com.crypto.exchange.server.service;

import com.crypto.exchange.server.client.MessariClient;
import com.crypto.exchange.server.models.domain.marketdata.MarketData;
import com.crypto.exchange.server.models.domain.marketdata.MarketDataResponse;
import com.crypto.exchange.server.repository.MarketDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class MarketDataService {

    MessariClient messariClient;
    MarketDataRepository marketDataRepository;

    public MarketData getMarketDataResponse(String assetKey) {
        Optional<MarketDataResponse> optMarketDataResponse = Optional.ofNullable(messariClient.getMarketData(assetKey.toLowerCase()));
        MarketData marketData = optMarketDataResponse.get().getReponseData().getMarketData();
        marketData.setAssetKey(assetKey);
        marketDataRepository.saveMarketData(marketData);
        return marketData;
    }
}
