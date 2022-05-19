package com.crypto.exchange.server.repository.impl;



import com.crypto.exchange.server.exception.DataNotPersistedException;
import com.crypto.exchange.server.models.old.common.entity.ProfileEntity;
import com.crypto.exchange.server.repository.AssetProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;


@Repository
@AllArgsConstructor
public class AssetProfileRepositoryIMPL implements AssetProfileRepository {

    private EntityManager entityManager;

    public void saveAssetProfile(ProfileEntity formattedProfile) {
        try {
            entityManager.persist(formattedProfile);
        } catch (Exception exception) {
            throw new DataNotPersistedException(exception.getMessage());
        }
    }

    public Optional<ProfileEntity> retrieveAssetProfile(String assetName) {
        return Optional.ofNullable(entityManager.find(ProfileEntity.class, assetName));
    }

}