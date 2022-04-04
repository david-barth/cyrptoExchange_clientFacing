package com.crypto.exchange.server.repository.impl;

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

        //Continuation:
            //Debugging => ContributorGroup saved first before contributors.
            //Need to figure out the correct direction and annotation combination to save the contributor + contributor group pairing. 

        Contributors contributorsExample = assetProfile.getData().getProfile().getContributors();
        entityManager.persist(contributorsExample);

    }

}
