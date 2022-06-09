package com.crypto.exchange.server.repository.impl;

import com.crypto.exchange.server.exception.DataNotPersistedException;
import com.crypto.exchange.server.models.domain.Exchange.Exchange;
import com.crypto.exchange.server.models.domain.Exchange.ExchangeRequestBody;
import com.crypto.exchange.server.repository.ExchangeDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Repository
public class ExchangeDataRepositoryImpl implements ExchangeDataRepository {

    @Autowired
    private MongoTemplate mongoTemplate;
    private int currentExchangeCount = 0;

    //TODO: currentExchangeCount is a weak way of ensuring existence of documents in collection.
    @Transactional
    public void saveAllExchanges(List<Exchange> newExchanges) {
        try {
            if (currentExchangeCount == 0) {
                mongoTemplate.insert(newExchanges, Exchange.class);
                currentExchangeCount = newExchanges.size();
                return;
            }
            mongoTemplate.remove(new Query(), "Exchanges");
            mongoTemplate.insert(newExchanges, Exchange.class);
            currentExchangeCount = newExchanges.size();
        } catch (Exception exception) {
            throw new DataNotPersistedException(exception.getMessage());
        }
    }

    @Transactional
    public List<Exchange> getAllExchanges() {
        return mongoTemplate.findAll(Exchange.class);
    }


    //TODO: Continuation point => Debug why exchanges cannot be retrieved.
    @Transactional
    public List<Exchange> getExchangeSubset(ExchangeRequestBody request) {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("exchange").is(request.getExchangeName()));
            query.addCriteria(Criteria.where("priceUSD").lte(request.getLowerBound()));
            query.addCriteria(Criteria.where("priceUSD").gte(request.getLowerBound()));
            return mongoTemplate.find(query, Exchange.class);
        } catch (Exception exc) {
            throw new EntityNotFoundException("Could not retrieve exchanges");
        }
    }

    public boolean exchangesExist() {
        return currentExchangeCount > 0;
    }

}
