package com.crypto.exchange.server.models.domain.marketdata;

import lombok.Data;

@Data
public class Asset {
    String id;
    String symbol;
    String name;
}