package com.crypto.exchange.server.repository;


import com.crypto.exchange.server.models.domain.marketdata.MarketData;
import com.crypto.exchange.server.models.domain.marketdata.ResponseData;
import java.util.Optional;

public interface MarketDataRepository {
    Optional<ResponseData> findMarketData(String assetKey);
    void saveMarketData(MarketData marketData);
}
