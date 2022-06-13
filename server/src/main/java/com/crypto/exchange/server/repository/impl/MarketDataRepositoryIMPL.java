package com.crypto.exchange.server.repository.impl;

import com.crypto.exchange.server.models.domain.marketdata.MarketData;
import com.crypto.exchange.server.repository.MarketDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

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

    public List<MarketData> getMarketDataByAsset(String assetKey) {
        Query query = new Query(where("_id").is(assetKey.toLowerCase()));
        return mongoTemplate.find(query, MarketData.class);
    }
}
