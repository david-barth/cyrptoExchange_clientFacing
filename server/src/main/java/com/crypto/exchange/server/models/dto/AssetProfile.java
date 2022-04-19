package com.crypto.exchange.server.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssetProfile {
    String assetName;
    GeneralData general;
    Contributors contributors;
}
