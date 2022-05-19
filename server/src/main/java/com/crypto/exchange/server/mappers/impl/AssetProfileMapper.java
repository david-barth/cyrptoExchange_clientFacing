package com.crypto.exchange.server.mappers.impl;

import com.crypto.exchange.server.models.old.common.Contributor;
import com.crypto.exchange.server.models.old.common.Link;
import com.crypto.exchange.server.models.old.common.RoadMapItem;
import com.crypto.exchange.server.models.old.common.dto.GeneralData;
import com.crypto.exchange.server.models.old.common.dto.Overview;
import com.crypto.exchange.server.models.old.common.dto.Profile;
import com.crypto.exchange.server.models.old.common.dto.ProfileData;
import com.crypto.exchange.server.models.old.common.entity.ProfileEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.function.Function;


@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AssetProfileMapper implements Function<Profile, ProfileEntity> {

    public static final AssetProfileMapper ASSET_PROFILE_MAPPER = new AssetProfileMapper();

    public ProfileEntity apply(Profile profileDTO) {

        //Get individual parts:
        ProfileData profileData = profileDTO.getData();
        Set<Contributor> contributorsList = profileDTO.getData().getProfile().getContributors().getIndividuals();
        GeneralData general = profileDTO.getData().getProfile().getGeneral();
        Overview overview = general.getOverview();
        Set<RoadMapItem> roadMapItems = general.getRoadmap();
        Set<Link> links = overview.getOfficial_links();

        //Set new values to DTO to flatten data:
        ProfileEntity profile = ProfileEntity.builder()
                .assetName(profileData.getSymbol())
                .category(overview.getCategory())
                .name(profileData.getName())
                .individuals(contributorsList)
                .roadmap(roadMapItems)
                .sector(overview.getSector())
                .slug(profileData.getSlug())
                .tagline(overview.getTagline())
                .official_links(links)
                .symbol(profileData.getSymbol())
                .build();

        return profile;
    }
}
