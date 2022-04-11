package com.crypto.exchange.server.repository;


import com.crypto.exchange.server.entity.domain.assetProfiles.AssetProfile;
import com.crypto.exchange.server.entity.domain.assetProfiles.Profile;

public interface AssetProfileRepository {
    void saveAssetProfile(Profile assetProfile);
    String retrieveAssetOnRecord(String assetName);
    AssetProfile retrieveAssetProfile(String assetName);
}