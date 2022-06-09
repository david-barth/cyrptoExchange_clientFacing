package com.crypto.exchange.server.models.domain.Exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Exchanges")
@Data
public class Exchange {

    @JsonProperty("exchange_name")
    String exchange;

    @JsonProperty("class")
    String exchangeClass;

    @JsonProperty("excluded_from_price")
    boolean excludedFromPrice;

    @JsonProperty("exchange_slug")
    String exchangeSlug;

    @JsonProperty("base_asset_symbol")
    String baseAssetSymbol;

    @JsonProperty("quote_asset_symbol")
    String quoteAssetSymbol;

    String pair;

    @JsonProperty("price_usd")
    float priceUSD;

    @JsonProperty("volume_last_24_hours")
    double lastDayVolume;

    @JsonProperty("deviation_from_vwap_percent")
    float deviationVWAP;

    @JsonProperty("last_trade_at")
    String lastTraded;
}
