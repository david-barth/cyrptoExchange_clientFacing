package com.crypto.exchange.server.models.dto;

import lombok.Data;

@Data
public class AssetProfile {
    String assetName;
    GeneralData general;
    Contributors contributors;
}
