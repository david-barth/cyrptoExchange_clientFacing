package com.crypto.exchange.server.models.dto;

import com.crypto.exchange.server.models.common.RoadMapItem;
import lombok.Builder;
import lombok.Data;
import java.util.Set;

@Data
@Builder
public class GeneralData {
    Overview overview;
    Set<RoadMapItem> roadmap;
}
