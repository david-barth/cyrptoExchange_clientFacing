package com.crypto.exchange.server.repository.impl;

import com.crypto.exchange.server.models.domain.Exchange.Exchange;
import com.crypto.exchange.server.models.domain.Exchange.ExchangeRequestBody;
import com.crypto.exchange.server.repository.ExchangeDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ExchangeDataRepositoryImpl implements ExchangeDataRepository {

    @Autowired
    private MongoTemplate mongoTemplate;
    private int currentExchangeCount = 0;

    @Transactional
    public void saveAllExchanges(List<Exchange> newExchanges) {
            if (currentExchangeCount == 0) {
                mongoTemplate.insert(newExchanges, Exchange.class);
                currentExchangeCount = newExchanges.size();
                return;
            }
            mongoTemplate.remove(new Query(), "Exchanges");
            mongoTemplate.insert(newExchanges, Exchange.class);
            currentExchangeCount = newExchanges.size();
    }

    @Transactional
    public List<Exchange> getAllExchanges() {
        return mongoTemplate.findAll(Exchange.class);
    }


    @Transactional
    public List<Exchange> getExchangeSubset(ExchangeRequestBody request) {
            Query query = new Query();
            query.addCriteria(Criteria.where("exchange").is(request.getExchangeName()));
            query.addCriteria(Criteria.where("priceUSD").lte(request.getLowerBound()).gte(request.getUpperBound()));
            return mongoTemplate.find(query, Exchange.class);
    }

    @Transactional
    public List<Exchange> getExchangesByQuoteSymbol(String assetKey) {
        Query query = new Query(Criteria.where("quoteAssetSymbol"));
        return mongoTemplate.find(query, Exchange.class);
    }


    public boolean exchangesExist() {
        return currentExchangeCount > 0;
    }

}
