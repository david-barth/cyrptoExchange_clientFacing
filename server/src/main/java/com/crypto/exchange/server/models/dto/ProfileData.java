package com.crypto.exchange.server.models.dto;


import lombok.Data;


@Data
public class ProfileData {
    String symbol;
    String name;
    String slug;
    AssetProfile profile;
}
