package com.crypto.exchange.server.repository;


import com.crypto.exchange.server.models.dto.AssetProfile;
import com.crypto.exchange.server.models.dto.Profile;

public interface AssetProfileRepository {
    void saveAssetProfile(Profile assetProfile, String assetName);
    AssetProfile retrieveAssetProfile(String assetName);
}