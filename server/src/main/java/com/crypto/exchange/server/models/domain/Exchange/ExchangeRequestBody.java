package com.crypto.exchange.server.models.domain.Exchange;

import lombok.Data;

@Data
public class ExchangeRequestBody {
    String exchangeName;
    float upperBound;
    float lowerBound;
}
