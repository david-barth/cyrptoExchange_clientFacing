package com.crypto.exchange.server.entity.domain.assetProfiles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Overview {
    String tagline;
    String category;
    String sector;
    String project_details;
    List<Links> official_links;
}
