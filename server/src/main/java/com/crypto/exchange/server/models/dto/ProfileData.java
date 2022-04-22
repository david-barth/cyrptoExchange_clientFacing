package com.crypto.exchange.server.models.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileData {
    String symbol;
    String name;
    String slug;
    AssetProfile profile;
}
