package com.crypto.exchange.server.repository.impl;

import com.crypto.exchange.server.models.common.Contributor;
import com.crypto.exchange.server.models.common.Link;
import com.crypto.exchange.server.models.common.RoadMapItem;
import com.crypto.exchange.server.models.entity.ProfileEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) //Extends the behavior of test classes with an additional class.  This allows mocks to be used.
public class AssetProfileRepositoryIMPLTestMockitoVersion {

    @Mock //Specifies this as a mock to be used.
    EntityManager entityManagerMock;

    @InjectMocks //Acts to inject any class marked with @Mock into the class.
    AssetProfileRepositoryIMPL testRepo;

    ProfileEntity testProfileEntity;


    //Note: There is very little point in mocking the Repo class as this should be more properly tested with integration style testing.
    @Test
    public void testRetrieveAssetProfileForSuccessfulRetrieval() {
        when(entityManagerMock.find(ProfileEntity.class,"BTC")).thenReturn(testProfileEntity);
        ProfileEntity actualProfile = testRepo.retrieveAssetProfile("BTC").get();
        Assertions.assertEquals(actualProfile.getSymbol(), testProfileEntity.getSymbol());
        Assertions.assertEquals(actualProfile.getAssetName(), testProfileEntity.getAssetName());
        Assertions.assertEquals(actualProfile.getName(), testProfileEntity.getName());
        Assertions.assertEquals(actualProfile.getCategory(), testProfileEntity.getCategory());
        Assertions.assertEquals(actualProfile.getTagline(), testProfileEntity.getTagline());
    }


    @BeforeEach
    public void init() {
        Contributor testContributor = Contributor.builder()
                .avatar_url("https://someURL.com")
                .first_name("David")
                .last_name("Barth")
                .slug("Some slug")
                .title("The title")
                .build();
        Set<Contributor> testContributors = new HashSet<>();
        testContributors.add(testContributor);

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


        testProfileEntity = ProfileEntity.builder()
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
    }
}
