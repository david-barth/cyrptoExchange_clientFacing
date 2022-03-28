package com.crypto.exchange.server.controller;

import com.crypto.exchange.server.entity.domain.assetProfiles.AssetList;
import com.crypto.exchange.server.entity.domain.assetProfiles.Profile;
import com.crypto.exchange.server.service.AssetProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@AllArgsConstructor
public class AssetProfileController {

    private AssetProfileService assetProfileService;

    //TODO: Implement Redis caching in order to optimize retrieval time
    @GetMapping("getProfile/{assetName}")
    public Profile getAssetProfile(@PathVariable String assetName) {
        return assetProfileService.fetchAssetProfileInfo("/v2/assets/" + assetName + "/profile");
    }

    @PostMapping("getProfileList")
    public List<Profile> getAssetQuoteList(@RequestBody AssetList assetList) {
        List<Profile> assetProfileList = new ArrayList<>();
        for (String assetName : assetList.getAssetList()) {
            Profile assetProfile = assetProfileService.fetchAssetProfileInfo("/v2/assets/" + assetName + "/profile");
            assetProfileList.add(assetProfile);
        }
        return assetProfileList;
    }

}
