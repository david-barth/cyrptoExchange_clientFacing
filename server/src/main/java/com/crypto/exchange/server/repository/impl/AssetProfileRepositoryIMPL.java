package com.crypto.exchange.server.repository.impl;


import com.crypto.exchange.server.models.dto.AssetProfile;
import com.crypto.exchange.server.models.dto.Profile;
import com.crypto.exchange.server.repository.AssetProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
@AllArgsConstructor
public class AssetProfileRepositoryIMPL implements AssetProfileRepository {

    private EntityManager entityManager;


    public void saveAssetProfile(Profile profileContainer, String assetName) {
        AssetProfile assetProfile = profileContainer.getData().getProfile();
        assetProfile.setAssetName(assetName);
        entityManager.persist(assetProfile);
    }

    public AssetProfile retrieveAssetProfile(String assetName) {
        return entityManager.find(AssetProfile.class, assetName);
    }

}