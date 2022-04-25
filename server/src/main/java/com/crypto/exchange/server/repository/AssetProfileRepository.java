package com.crypto.exchange.server.repository;

import com.crypto.exchange.server.models.entity.ProfileEntity;

public interface AssetProfileRepository {
    void saveAssetProfile(ProfileEntity assetProfile);
    ProfileEntity retrieveAssetProfile(String assetName);
}