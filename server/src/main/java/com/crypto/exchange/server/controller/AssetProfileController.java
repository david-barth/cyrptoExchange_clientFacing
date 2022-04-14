package com.crypto.exchange.server.controller;

import com.crypto.exchange.server.models.dto.Profile;
import com.crypto.exchange.server.service.AssetProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class AssetProfileController {

    private AssetProfileService assetProfileService;

    //TODO: Implement code to flatten DTO to an entity object with a better set of tables.
    @GetMapping("profile/{assetName}")
    public Profile getAssetProfile(@PathVariable String assetName) {
        return assetProfileService.fetchAssetProfileInfo("/v2/assets/" + assetName + "/profile", assetName);
    }



    //TODO: Fix Code for the assetList
    /*@PostMapping("getProfileList")
    public List<Profile> getAssetQuoteList(@RequestBody AssetList assetList) {
        List<Profile> assetProfileList = new ArrayList<>();
        for (String assetName : assetList.getAssetList()) {
            Profile assetProfile = assetProfileService.fetchAssetProfileInfo("/v2/assets/" + assetName + "/profile");
            assetProfileList.add(assetProfile);
        }
        return assetProfileList;
    }*/

}
