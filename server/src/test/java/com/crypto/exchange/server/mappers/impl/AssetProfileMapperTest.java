package com.crypto.exchange.server.mappers.impl;

import com.crypto.exchange.server.mappers.UnidirectionalBaseMapper;
import com.crypto.exchange.server.models.common.Contributor;
import com.crypto.exchange.server.models.common.Link;
import com.crypto.exchange.server.models.common.RoadMapItem;
import com.crypto.exchange.server.models.dto.*;
import com.crypto.exchange.server.models.entity.ProfileEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.internal.util.Assert;


import java.util.HashSet;
import java.util.Set;


public class AssetProfileMapperTest {

    private UnidirectionalBaseMapper<ProfileEntity, Profile> assetProfileMapper = new AssetProfileMapper();
    private ProfileEntity expectedProfileEntity;
    private Profile testProfile;


    //Normal expected output:
    @Test
    public void testAssetProfileMappingForNormalOutput() {
        ProfileEntity testProfileEntity = assetProfileMapper.mapObject(testProfile);
        Assertions.assertEquals(expectedProfileEntity, testProfileEntity);
    }


    //Test for appropriate Mapped Object Type:
    @Test
    public void testForProfileEntityTypeAfterMapping() {
        ProfileEntity testProfileEntity = assetProfileMapper.mapObject(testProfile);
        Assertions.assertTrue(expectedProfileEntity instanceof ProfileEntity); //Bad practice, boolean condition is ambiguous.  Should use assertThat for type check.
    }


    //Output with 1 null value:
    @Test
    public void testMappedEntityForOneNullValueMapping() {
        testProfile.getData().setSymbol(null);
        ProfileEntity testProfileEntity = assetProfileMapper.mapObject(testProfile);
        Assert.isNull(testProfileEntity.getSymbol());
    }

    //Output for multiple null values:
    @Test
    public void testMappedEntityForMultipleNullValuesMapping() {
        testProfile.getData().getProfile().getGeneral().getOverview().setCategory(null);
        testProfile.getData().getProfile().getGeneral().getOverview().setSector(null);
        testProfile.getData().setName(null);
        testProfile.getData().setSymbol(null);

        ProfileEntity testProfileEntity = assetProfileMapper.mapObject(testProfile);

        Assert.isNull(testProfileEntity.getCategory());
        Assert.isNull(testProfileEntity.getSector());
        Assert.isNull(testProfileEntity.getName());
        Assert.isNull(testProfileEntity.getSymbol());
    }

    //Test for what happens when the root of the DTO is removed:
    @Test
    public void testMappingProcessForWhenRootIsRemoved() {
        testProfile.setData(null);
        Assertions.assertThrows(NullPointerException.class, () -> {
            assetProfileMapper.mapObject(testProfile);
        });
    }


    @BeforeEach
    public void initMapperTest() {
        Contributor testContributor = Contributor.builder()
                .avatar_url("https://someURL.com")
                .first_name("David")
                .last_name("Barth")
                .slug("Some slug")
                .title("The title")
                .build();
        Set<Contributor> testContributors = new HashSet<>();
        testContributors.add(testContributor);

        Contributors testContributorGroup = Contributors.builder()
                .individuals(testContributors)
                .build();


        Link testLink = Link.builder()
                .link("https://someURLAgain.com")
                .name("The link")
                .build();
        Set<Link> testLinks = new HashSet<>();
        testLinks.add(testLink);

        RoadMapItem testRoadMapItem = RoadMapItem.builder()
                .title("M-of-N Standard Transactions")
                .date("2011-10-02T04:00:00Z")
                .type("Testnet Launch")
                .build();
        Set<RoadMapItem> testRoadMap = new HashSet<>();
        testRoadMap.add(testRoadMapItem);

        Overview testOverview = Overview.builder()
                .official_links(testLinks)
                .category("Payments")
                .tagline("A peer-to-peer electronic cash")
                .sector("Currencies")
                .build();

        GeneralData testGeneralData = GeneralData.builder()
                .overview(testOverview)
                .roadmap(testRoadMap)
                .build();

        AssetProfile testAssetProfile = AssetProfile.builder()
                .assetName("BTC")
                .general(testGeneralData)
                .contributors(testContributorGroup)
                .build();

        ProfileData testProfileData = ProfileData.builder()
                .profile(testAssetProfile)
                .name("Bitcoin")
                .symbol("BTC")
                .slug("bitcoin")
                .build();

        Profile testProfile = Profile.builder().data(testProfileData).build();

        ProfileEntity expectedProfileEntity = ProfileEntity.builder()
                .assetName("BTC")
                .category("Payments")
                .name("Bitcoin")
                .individuals(testContributors)
                .roadmap(testRoadMap)
                .sector("Currencies")
                .slug("bitcoin")
                .tagline("A peer-to-peer electronic cash")
                .official_links(testLinks)
                .symbol("BTC")
                .build();

        this.testProfile = testProfile;
        this.expectedProfileEntity = expectedProfileEntity;
    }


}