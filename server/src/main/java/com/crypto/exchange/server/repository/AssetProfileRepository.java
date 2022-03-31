package com.crypto.exchange.server.repository;


import com.crypto.exchange.server.entity.domain.assetProfiles.Profile;

public interface AssetProfileRepository {
    void saveAssetProfile(Profile assetProfile);
}
