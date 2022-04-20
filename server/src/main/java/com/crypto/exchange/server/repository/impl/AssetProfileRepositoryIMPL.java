package com.crypto.exchange.server.repository.impl;



import com.crypto.exchange.server.exception.DataNotPersistedException;
import com.crypto.exchange.server.models.entity.ProfileEntity;
import com.crypto.exchange.server.repository.AssetProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


@Repository
@AllArgsConstructor
public class AssetProfileRepositoryIMPL implements AssetProfileRepository {

    private EntityManager entityManager;

    //Code smell: Not having some sort of exception emitted here and/or a success boolean emitted upon successful persisting
    //TODO: Refactor this try - catch when a proper aspect based error handler is implemented here.
    public void saveAssetProfile(ProfileEntity formattedProfile) {
        try {
            entityManager.persist(formattedProfile);
        } catch (Exception exception) {
            throw new DataNotPersistedException(exception.getMessage());
        }
    }

    public ProfileEntity retrieveAssetProfile(String assetName) {
        return entityManager.find(ProfileEntity.class, assetName);
    }

}