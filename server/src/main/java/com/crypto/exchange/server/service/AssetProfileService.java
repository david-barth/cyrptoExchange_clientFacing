package com.crypto.exchange.server.service;

import com.crypto.exchange.server.entity.domain.assetProfiles.Profile;
import com.crypto.exchange.server.repository.AssetProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class AssetProfileService {

    private AssetProfileRepository profileRepo;
    private WebClient cryptoInfoWebClient;

    public Profile fetchAssetProfileInfo(String assetURI) {
        return cryptoInfoWebClient.get()
                .uri(assetURI)
                .retrieve()
                .bodyToMono(Profile.class)
                .block();
    }

}
