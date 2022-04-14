package com.crypto.exchange.server.service;

import com.crypto.exchange.server.models.dto.Profile;
import com.crypto.exchange.server.models.dto.ProfileData;
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



    //Create mapper first:
    @Transactional
    public Profile fetchAssetProfileInfo(String assetURI, String assetName) {
        Profile assetProfile;
        boolean isAssetPresent = true;
        if (isAssetPresent) {
            assetProfile = new Profile();
            ProfileData profileData = new ProfileData();
            profileData.setProfile(profileRepo.retrieveAssetProfile(assetName));
            assetProfile.setData(profileData);
            return assetProfile;
        }
        else {
            assetProfile = cryptoInfoWebClient.get()
                    .uri(assetURI)
                    .retrieve()
                    .bodyToMono(Profile.class)
                    .block();
            profileRepo.saveAssetProfile(assetProfile, assetName);
            return assetProfile;
        }
    }

}
