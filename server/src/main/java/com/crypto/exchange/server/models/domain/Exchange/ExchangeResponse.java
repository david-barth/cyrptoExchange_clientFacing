package com.crypto.exchange.server.models.domain.Exchange;

import lombok.Data;

import java.util.List;

@Data
public class ExchangeResponse {
    List<Exchange> data;
}
