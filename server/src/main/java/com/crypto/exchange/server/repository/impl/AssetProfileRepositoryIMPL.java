package com.crypto.exchange.server.repository.impl;

import com.crypto.exchange.server.entity.domain.assetProfiles.Contributor;
import com.crypto.exchange.server.entity.domain.assetProfiles.Contributors;
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

        //Opened Transaction
        //Add Contributor group to Contributor to ensure bi-directionality is obeyed:
        Contributors contributorsExample = assetProfile.getData().getProfile().getContributors();

        for (Contributor contributor : contributorsExample.getIndividuals()) {
            contributor.setContributors(contributorsExample);
        }

        entityManager.persist(contributorsExample);
        //Closed Transaction
    }

}
