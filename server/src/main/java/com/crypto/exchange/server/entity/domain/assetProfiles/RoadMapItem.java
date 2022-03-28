package com.crypto.exchange.server.entity.domain.assetProfiles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RoadMapItem {
    String title;
    String date;
    String type;
    String details;
}
