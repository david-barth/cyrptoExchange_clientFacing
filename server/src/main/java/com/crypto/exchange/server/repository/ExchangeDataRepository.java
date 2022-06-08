package com.crypto.exchange.server.repository;

import com.crypto.exchange.server.models.domain.Exchange.Exchange;

import java.util.List;

public interface ExchangeDataRepository {
    public void saveAllExchanges(List<Exchange> exchanges);
    public List<Exchange> getAllExchanges();
}
