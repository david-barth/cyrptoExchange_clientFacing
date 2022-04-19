package com.crypto.exchange.server.mappers.impl;

import com.crypto.exchange.server.mappers.UnidirectionalBaseMapper;
import com.crypto.exchange.server.models.common.Contributor;
import com.crypto.exchange.server.models.common.Link;
import com.crypto.exchange.server.models.common.RoadMapItem;
import com.crypto.exchange.server.models.dto.*;
import com.crypto.exchange.server.models.entity.ProfileEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
@AllArgsConstructor
public class AssetProfileMapper implements UnidirectionalBaseMapper<ProfileEntity, Profile> {


    //TODO: Figure out best way to handle mapper error when root is null in DTO (Ie handle nullpointer exception)
    public ProfileEntity mapObject(Profile profileDTO) {

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
