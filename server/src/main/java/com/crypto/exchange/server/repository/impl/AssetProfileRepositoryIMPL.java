package com.crypto.exchange.server.repository.impl;



import com.crypto.exchange.server.models.entity.ProfileEntity;
import com.crypto.exchange.server.repository.AssetProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
@AllArgsConstructor
public class AssetProfileRepositoryIMPL implements AssetProfileRepository {

    private EntityManager entityManager;


    public void saveAssetProfile(ProfileEntity formattedProfile) {
        entityManager.persist(formattedProfile);
    }

    public ProfileEntity retrieveAssetProfile(String assetName) {
        return entityManager.find(ProfileEntity.class, assetName);
    }

}