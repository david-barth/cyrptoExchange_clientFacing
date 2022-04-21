package com.crypto.exchange.server.controller;

import com.crypto.exchange.server.models.dto.Profile;
import com.crypto.exchange.server.models.entity.ProfileEntity;
import com.crypto.exchange.server.service.AssetProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class AssetProfileController {

    private AssetProfileService assetProfileService;

    @GetMapping("profile/{assetName}")
    public ProfileEntity getAssetProfile(@PathVariable String assetName) {
        return assetProfileService.fetchAssetProfileInfo("/v2/assets/" + assetName + "/profile", assetName);
    }

}
