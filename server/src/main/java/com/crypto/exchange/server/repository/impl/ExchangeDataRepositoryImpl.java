package com.crypto.exchange.server.repository.impl;

import com.crypto.exchange.server.models.domain.Exchange.Exchange;
import com.crypto.exchange.server.repository.ExchangeDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@AllArgsConstructor
public class ExchangeDataRepositoryImpl implements ExchangeDataRepository {

    private MongoTemplate mongoTemplate;
    private int currentExchangeCount = 0;

    @Transactional
    public void saveAllExchanges(List<Exchange> newExchanges) {
        //If empty, we save all documents
        if (currentExchangeCount == 0) {
            mongoTemplate.insert(newExchanges);
            currentExchangeCount = newExchanges.size();
            return;
        }

        //Remove all records from the collection:
        //TODO: Not necessarily very performant or selective. Can write more specific queries to selectively update records.
        mongoTemplate.remove(new Query(), "Exchanges");
        mongoTemplate.insert(newExchanges);
        currentExchangeCount = newExchanges.size();
    };

    @Transactional
    public List<Exchange> getAllExchanges() {
        return mongoTemplate.findAll(Exchange.class);
    };


}
