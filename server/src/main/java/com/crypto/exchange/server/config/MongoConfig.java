package com.crypto.exchange.server.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@AllArgsConstructor
@EnableConfigurationProperties
public class MongoConfig {

    private YAMLConfigMongo configProps;

    @Bean
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(configProps.getUrl());
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                                                                        .applyConnectionString(connectionString)
                                                                        .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), configProps.getDBname());
    }

    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

}
