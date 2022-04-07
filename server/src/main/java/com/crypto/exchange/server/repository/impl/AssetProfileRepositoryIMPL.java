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

    /* Continuation notes:
        1. The data model needs to be redefined to include unique constrains on the names of the cryptocurrencies to ensure adequate retrieval of the profile for checking.
        2. A new repository method for retrieving a unique cryptocurrency profile signature must be obtained for the verification step in the AssetProfileService REST call.
        3. The service methods must be refactored to include the check in the database for the identifier.
        4. The retrieve profiles resource endpoint must be refactored to retrieve all cryptocurrency profiles specified in the POST body.
    * */



    public void saveAssetProfile(Profile assetProfile) {
        entityManager.persist(assetProfile.getData().getProfile());
    }



}
