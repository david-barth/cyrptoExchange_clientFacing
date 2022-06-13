package com.crypto.exchange.server.repository;

import com.crypto.exchange.server.models.domain.Exchange.Exchange;
import com.crypto.exchange.server.models.domain.Exchange.ExchangeRequestBody;

import java.util.List;

public interface ExchangeDataRepository {
    public void saveAllExchanges(List<Exchange> exchanges);
    public List<Exchange> getAllExchanges();
    public boolean exchangesExist();
    public List<Exchange> getExchangeSubset(ExchangeRequestBody request);
    public List<Exchange> getExchangesByQuoteSymbol(String assetKey);
}
