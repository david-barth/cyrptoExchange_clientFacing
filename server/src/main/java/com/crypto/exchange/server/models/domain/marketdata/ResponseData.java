package com.crypto.exchange.server.models.domain.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseData {
    @JsonProperty("Asset")
    Asset asset;

    @JsonProperty("market_data")
    MarketData marketData;
}

