package com.crypto.exchange.server.models.domain.marketdata;

import com.crypto.exchange.server.models.domain.marketdata.MarketData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseData {

    String id;
    String symbol;
    String name;

    @JsonProperty("market_data")
    MarketData marketData;
}

