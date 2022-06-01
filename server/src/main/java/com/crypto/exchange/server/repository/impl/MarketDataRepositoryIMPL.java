package com.crypto.exchange.server.repository.impl;

import com.crypto.exchange.server.models.domain.marketdata.MarketData;
import com.crypto.exchange.server.models.domain.marketdata.ResponseData;
import com.crypto.exchange.server.repository.MarketDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class MarketDataRepositoryIMPL implements MarketDataRepository {


    public Optional<ResponseData> findMarketData(String assetKey) {
        return Optional.empty();
    }


    public void saveMarketData(MarketData marketData) {

    }
}
