package com.crypto.exchange.server.models.domain.transfer;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("CointAnalytics")
@Data
public class CointAnalytics {
    private int assetProfileCount;
    private int contributorCount;
    private int linksCount;
    private int roadItemsCount;
    private double totalVolumeOverEntries;
    private float averagePriceOverEntries;
}
