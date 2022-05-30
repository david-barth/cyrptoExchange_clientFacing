package com.crypto.exchange.server.service;

import com.crypto.exchange.server.mappers.impl.AssetProfileMapper;
import com.crypto.exchange.server.models.old.common.Contributor;
import com.crypto.exchange.server.models.old.common.Link;
import com.crypto.exchange.server.models.old.common.RoadMapItem;
import com.crypto.exchange.server.models.old.common.dto.*;
import com.crypto.exchange.server.models.old.common.entity.ProfileEntity;
import com.crypto.exchange.server.repository.AssetProfileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AssetProfileServiceTest {

    @Mock
    private AssetProfileRepository mockAssetProfileRepo;

    @Mock
    private WebClient mockWebClient;

    @Mock
    private AssetProfileMapper mockMapper;

    @Mock
    private WebClient.RequestHeadersUriSpec mockURISpec;

    @Mock
    private WebClient.RequestHeadersSpec mockRequestHeaderSpec;

    @Mock
    private  WebClient.ResponseSpec mockResponseSpec;

    @Mock
    private Mono<Profile> mockMonoProfile;

    @InjectMocks
    private AssetProfileService testService;

    private ProfileEntity actualProfileEntity;
    private Profile testDTO;
    private String assetURI = "https://data.messari.io/api/v2/assets/BTC/profile";


    //Retrieved successfully with already saved profile: assetName has been supplied previously
    @Test
    public void givenAProperAssetName_whenRetrievingAssetProfile_thenSuccessfulRetrievalFromDB() {
        when(mockAssetProfileRepo.retrieveAssetProfile("BTC")).thenReturn(Optional.ofNullable(actualProfileEntity));
        ProfileEntity testProfileEntity = testService.fetchAssetProfileInfo(assetURI, "BTC");
        Assertions.assertEquals(testProfileEntity, actualProfileEntity);
    }


    //Mockito for Method Chaining: Need to use a when().thenReturn() for each method in the chain.
    //Each method requires an object to feed to the next.
    @Test
    @Disabled("Temporarily disabled until opportunity to fix comes")
    public void givenANewAssetName_whenRetrievingAssetProfile_thenSuccessfulRESTCall() {
        when(mockWebClient.get()).thenReturn(mockURISpec);
        when(mockURISpec.uri(assetURI)).thenReturn(mockRequestHeaderSpec);
        when(mockRequestHeaderSpec.retrieve()).thenReturn(mockResponseSpec);
        when(mockResponseSpec.bodyToMono(Profile.class)).thenReturn(mockMonoProfile);
        when(mockMonoProfile.block()).thenReturn(testDTO);
        when(mockMapper.apply(testDTO)).thenReturn(actualProfileEntity);
        ProfileEntity testProfileEntity = testService.fetchAssetProfileInfo(assetURI, "BTC");
        Assertions.assertEquals(actualProfileEntity, testProfileEntity);
    }

    @Test
    public void givenANonExistingAssetName_whenMakingRESTCall_thenFailToRetrieveFromAPI() {
        when(mockWebClient.get()).thenReturn(mockURISpec);
        when(mockURISpec.uri(assetURI)).thenReturn(mockRequestHeaderSpec);
        when(mockRequestHeaderSpec.retrieve()).thenReturn(mockResponseSpec);
        when(mockResponseSpec.bodyToMono(Profile.class)).thenReturn(mockMonoProfile);
        when(mockMonoProfile.block()).thenThrow(WebClientResponseException.class);
        Assertions.assertThrows(WebClientResponseException.class,
                () -> testService.fetchAssetProfileInfo(assetURI, "BTC"));
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


        actualProfileEntity = ProfileEntity.builder()
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

        testDTO = generateTestDTO();
    }

    private Profile generateTestDTO() {
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
        Profile dtoProfile = new Profile();
        dtoProfile.setData(testProfileData);

        return dtoProfile;
    }
}
