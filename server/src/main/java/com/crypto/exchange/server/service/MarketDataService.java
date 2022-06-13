package com.crypto.exchange.server.service;

import com.crypto.exchange.server.client.MessariClient;
import com.crypto.exchange.server.models.domain.marketdata.MarketData;
import com.crypto.exchange.server.models.domain.marketdata.MarketDataResponse;
import com.crypto.exchange.server.models.domain.transfer.CointAnalytics;
import com.crypto.exchange.server.repository.MarketDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class MarketDataService {

    MessariClient messariClient;
    MarketDataRepository marketDataRepository;

    public MarketData getMarketDataResponse(String assetKey) {
        Optional<MarketData> optionalMarketData = marketDataRepository.findMarketData(assetKey);
        if (optionalMarketData.isPresent())
            return optionalMarketData.get();

        Optional<MarketDataResponse> optMarketDataResponse = Optional.ofNullable(messariClient.getMarketData(assetKey.toLowerCase()));
        MarketData marketData = optMarketDataResponse.get().getReponseData().getMarketData();
        marketData.setAssetKey(assetKey);
        marketDataRepository.saveMarketData(marketData);
        return marketData;
    }

    public CointAnalytics processAnalytics(CointAnalytics cointAnalytics, String assetKey) {
        List<MarketData> marketDataList = marketDataRepository.getMarketDataByAsset(assetKey);
        List<Double> realVolumes = marketDataList.stream()
                .map(marketData -> marketData.getRealLastDayVolume())
                .collect(Collectors.toList());

        cointAnalytics.setTotalVolumeOverEntries(realVolumes.stream()
                .reduce(0d, (partialVolume, currentVolume) -> partialVolume + currentVolume));

        return cointAnalytics;
    }
}
