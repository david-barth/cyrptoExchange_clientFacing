package com.crypto.exchange.server.models.domain.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MarketData {

    double price_usd;
    double price_btc;

    @JsonProperty("volume_last_24_hours")
    double lastDayVolume;

    @JsonProperty("real_volume_last_24_hours")
    double realLastDayVolume;

    @JsonProperty("volume_last_24_hours_overstatement_multiple")
    float lastDayVolumeOverStatementMultiple;

    @JsonProperty("percent_change_usd_last_24_hours")
    float lastDayPercentChangeUSD;

    @JsonProperty("percent_change_btc_last_24_hours")
    float lastDayPercentChangeBTC;


    //TODO: Can compress this to a list and perhaps use a customs serializer in order to make this work better.
    @JsonProperty("ohlcv_last_1_hour")
    Ohlcv lastHourOhlcv;

    @JsonProperty
    Ohlcv lastDayOHlcv;

}
