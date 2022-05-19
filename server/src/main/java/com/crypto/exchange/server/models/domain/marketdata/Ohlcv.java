package com.crypto.exchange.server.models.domain.marketdata;

import lombok.Data;

@Data
public class Ohlcv {
    float open;
    float high;
    float low;
    float close;
    double volume;
}
