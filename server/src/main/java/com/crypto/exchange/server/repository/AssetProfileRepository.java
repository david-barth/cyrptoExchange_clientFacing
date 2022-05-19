package com.crypto.exchange.server.repository;

import com.crypto.exchange.server.models.entity.ProfileEntity;

import java.util.Optional;

public interface AssetProfileRepository {
    void saveAssetProfile(ProfileEntity assetProfile);
    Optional<ProfileEntity> retrieveAssetProfile(String assetName);
}