package com.crypto.exchange.server.models.old.common.dto;

import com.crypto.exchange.server.models.old.common.RoadMapItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneralData {
    Overview overview;
    Set<RoadMapItem> roadmap;
}