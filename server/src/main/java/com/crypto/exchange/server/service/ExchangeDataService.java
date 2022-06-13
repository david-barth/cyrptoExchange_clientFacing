package com.crypto.exchange.server.service;

import com.crypto.exchange.server.client.MessariClient;
import com.crypto.exchange.server.models.domain.Exchange.Exchange;
import com.crypto.exchange.server.models.domain.Exchange.ExchangeRequestBody;
import com.crypto.exchange.server.models.domain.transfer.CointAnalytics;
import com.crypto.exchange.server.repository.ExchangeDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExchangeDataService {

    MessariClient messariClient;
    ExchangeDataRepository exchangeDataRepository;

    public List<Exchange> getAllExchanges() {
        if (exchangeDataRepository.exchangesExist()) {
            return exchangeDataRepository.getAllExchanges();
        }
        List<Exchange> exchanges = messariClient.getAllExchangeData().getData();
        exchangeDataRepository.saveAllExchanges(exchanges);
        return exchanges;
    }

    public List<Exchange> getExchangeSubset(ExchangeRequestBody request) {
        return exchangeDataRepository.getExchangeSubset(request);
    }

    public CointAnalytics processAnalytics(CointAnalytics cointAnalytics, String assetKey) {
        List<Float> exchangeList = exchangeDataRepository.getExchangesByQuoteSymbol(assetKey.toUpperCase())
                                                                    .stream()
                                                                    .map(exchange -> exchange.getPriceUSD())
                                                                    .collect(Collectors.toList());

        float averagePriceUDS = (exchangeList.stream().reduce(0.0f, (partialTotalUSD, priceUSD) -> partialTotalUSD + priceUSD)) / exchangeList.size();
        cointAnalytics.setAveragePriceOverEntries(averagePriceUDS);
        return cointAnalytics;
    }


}
