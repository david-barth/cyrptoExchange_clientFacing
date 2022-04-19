package com.crypto.exchange.server.service;

import com.crypto.exchange.server.mappers.impl.AssetProfileMapper;
import com.crypto.exchange.server.models.dto.Profile;
import com.crypto.exchange.server.models.entity.ProfileEntity;
import com.crypto.exchange.server.repository.AssetProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AssetProfileService {

    private AssetProfileRepository profileRepo;
    private WebClient cryptoInfoWebClient;
    private AssetProfileMapper mapper;


    //Note: 5x latency performance improvement with DB saving, rather than relying on the
    @Transactional
    public ProfileEntity fetchAssetProfileInfo(String assetURI, String assetName) {
        ProfileEntity retrievedProfile = profileRepo.retrieveAssetProfile(assetName);
        boolean isAssetPresent = Optional.ofNullable(retrievedProfile).isPresent();
        if (isAssetPresent) {
            return retrievedProfile;
        }
        else {
            Profile responseProfile = cryptoInfoWebClient.get()
                    .uri(assetURI)
                    .retrieve()
                    .bodyToMono(Profile.class)
                    .block();

            ProfileEntity formattedProfile = mapper.mapObject(responseProfile);
            profileRepo.saveAssetProfile(formattedProfile);
            return formattedProfile;
        }
    }

}
