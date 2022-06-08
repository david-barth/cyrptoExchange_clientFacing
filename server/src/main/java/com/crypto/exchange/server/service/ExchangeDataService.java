package com.crypto.exchange.server.service;

import com.crypto.exchange.server.client.MessariClient;
import com.crypto.exchange.server.models.domain.Exchange.Exchange;
import com.crypto.exchange.server.models.domain.Exchange.ExchangeResponse;
import com.crypto.exchange.server.repository.ExchangeDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExchangeDataService {


    MessariClient messariClient;
    ExchangeDataRepository exchangeDataRepository;

    //TODO: Continuation point
    public List<Exchange> getAllExchanges() {

        //Check to see if all Exchanges exist:

        ExchangeResponse exchangeResponse = messariClient.getAllExchangeData();

        //Pass off to save to DB:


        return exchangeResponse.getData();
    }


}
