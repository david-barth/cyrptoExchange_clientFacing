package com.crypto.exchange.server.controller;


import com.crypto.exchange.server.models.old.common.entity.ProfileEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;



@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class AssetProfileControllerTest {


    @Autowired
    private EntityManager entityManager;

    @Autowired
    private AssetProfileController testController;


    //Test 1: Use asset name of non-persisted asset to retrieve profile
    @Test
    public void givenANonPersistedAsset_whenMakingAProfileGetRequest_ThenGettingAGoodRESTResponse() {
        //Retrieve empty asset profile from database and delete if it exists:
        ProfileEntity actualProfile = getSOLAssetProfile();
        boolean isEntityPresent = Optional.ofNullable(actualProfile).isPresent();
        if (isEntityPresent) {
            entityManager.remove(actualProfile);
            actualProfile = null;
        }

        //Make controller "call":
        ProfileEntity testProfile = testController.getAssetProfile("SOL");

        //Retrieve new Profile from DB to confirm safe storage:
        actualProfile = getSOLAssetProfile();

        //Make assertion:
        Assertions.assertEquals(actualProfile, testProfile);
    }

    //Test 2: Use asset name of persisted asset to retrieve profile


    //Test 3: Use bad asset name for non-existing asset


    //Test 4: Use a number to retrieve profile (expect 404 based exception)


    //Test 5: Use a space query parameter


    private ProfileEntity getSOLAssetProfile() {
        return entityManager.find(ProfileEntity.class, "SOL");
    }
}
