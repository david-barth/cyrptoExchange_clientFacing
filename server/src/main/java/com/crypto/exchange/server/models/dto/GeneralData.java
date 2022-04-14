package com.crypto.exchange.server.models.dto;

import lombok.Data;
import java.util.Set;

@Data
public class GeneralData {
    Overview overview;
    Set<RoadMapItem> roadmap;
}
