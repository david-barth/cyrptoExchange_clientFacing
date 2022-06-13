package com.crypto.exchange.server.importers.analytics;

import com.crypto.exchange.server.importers.Importer;
import com.crypto.exchange.server.models.domain.transfer.CointAnalytics;
import com.crypto.exchange.server.service.AssetProfileService;
import com.crypto.exchange.server.service.ExchangeDataService;
import com.crypto.exchange.server.service.MarketDataService;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AnalyticsImporter implements Importer {


    private AssetProfileService assetProfileService;
    private MarketDataService marketDataService;
    private ExchangeDataService exchangeDataService;
    private MongoTemplate mongoTemplate;


    public void doImportAndAnalytics(String assetKey) {
        CointAnalytics analyticsEntry = new CointAnalytics();
        assetProfileService.processAnalytics(analyticsEntry, assetKey);
        marketDataService.processAnalytics(analyticsEntry, assetKey);
        exchangeDataService.processAnalytics(analyticsEntry, assetKey);
        mongoTemplate.insert(analyticsEntry);
    }
}
