package com.crypto.exchange.server.models.domain.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MarketDataResponse {

    Status status;

    @JsonProperty("data")
    ResponseData reponseData;

}
