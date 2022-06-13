package com.crypto.exchange.server.repository;


import com.crypto.exchange.server.models.domain.marketdata.MarketData;

import java.util.List;
import java.util.Optional;

public interface MarketDataRepository {
    Optional<MarketData> findMarketData(String assetKey);
    void saveMarketData(MarketData marketData);
    List<MarketData> getMarketDataByAsset(String assetKey);
}
