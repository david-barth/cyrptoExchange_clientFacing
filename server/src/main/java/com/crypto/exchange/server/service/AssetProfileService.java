package com.crypto.exchange.server.service;

import com.crypto.exchange.server.models.dto.Profile;
import com.crypto.exchange.server.models.entity.ProfileEntity;
import com.crypto.exchange.server.repository.AssetProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;

import static com.crypto.exchange.server.mappers.impl.AssetProfileMapper.ASSET_PROFILE_MAPPER;



import java.util.Optional;

@Service
@AllArgsConstructor
public class AssetProfileService {

    private AssetProfileRepository profileRepo;
    private WebClient cryptoInfoWebClient;


    @Transactional
    public ProfileEntity fetchAssetProfileInfo(String assetURI, String assetName) {
        Optional<ProfileEntity> retrievedProfile = profileRepo.retrieveAssetProfile(assetName);
        if (retrievedProfile.isPresent()) {
            return retrievedProfile.get();
        }

        Profile responseProfile = Optional.ofNullable(cryptoInfoWebClient.get()
                    .uri(assetURI)
                    .retrieve()
                    .bodyToMono(Profile.class)
                    .block()).orElseThrow();

        ProfileEntity formattedProfile = ASSET_PROFILE_MAPPER.apply(responseProfile);
        profileRepo.saveAssetProfile(formattedProfile);
        return formattedProfile;
    }
}


