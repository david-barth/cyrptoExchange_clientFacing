package com.crypto.exchange.server.repository.impl;

import com.crypto.exchange.server.entity.domain.assetProfiles.Profile;
import com.crypto.exchange.server.repository.AssetProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Repository
@AllArgsConstructor
@Transactional
public class AssetProfileRepositoryIMPL implements AssetProfileRepository {

    private EntityManager entityManager;

    public void saveAssetProfile(Profile assetProfile) {

        //Issue is definitely linked to DTO structure.
        //Best to either use DAO <-> DTO mapping (e.g. MapStruct)
        //Or figure out how to reimplement mapping relationships from ground up.  
        entityManager.persist(assetProfile.getData().getProfile().getGeneral().getOverview().getOfficial_links().get(0));

    }

}
