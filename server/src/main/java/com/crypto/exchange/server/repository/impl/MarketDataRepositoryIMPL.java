package com.crypto.exchange.server.repository.impl;

import com.crypto.exchange.server.models.domain.marketdata.MarketData;
import com.crypto.exchange.server.repository.MarketDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class MarketDataRepositoryIMPL implements MarketDataRepository {

    MongoTemplate mongoTemplate;

    public Optional<MarketData> findMarketData(String assetKey) {
        return Optional.ofNullable(mongoTemplate.findById(assetKey, MarketData.class));
    }


    public void saveMarketData(MarketData marketData) {
        mongoTemplate.insert(marketData);
    }
}
