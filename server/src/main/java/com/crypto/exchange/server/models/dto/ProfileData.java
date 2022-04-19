package com.crypto.exchange.server.models.dto;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ProfileData {
    String symbol;
    String name;
    String slug;
    AssetProfile profile;
}
