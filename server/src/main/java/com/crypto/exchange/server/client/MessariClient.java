package com.crypto.exchange.server.client;

import com.crypto.exchange.server.config.FeignConfig;
import com.crypto.exchange.server.models.domain.marketdata.MarketDataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "messariClient",
        url = "https://data.messari.io/api",
        configuration = FeignConfig.class)
public interface MessariClient {


    //TODO: Need to debug null values in response.
    //Get Asset Market Data
    @GetMapping(path = "/v1/assets/{assetKey}/metrics/market-data", produces = "application/json")
    MarketDataResponse getMarketData(@PathVariable String assetKey);



    //Get all News

    //Get News for Asset

    //Get all Markets

}
