package com.crypto.exchange.server.entity.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProfileData {
    private String symbol;
    private String name;
    private String slug;
    private AssetProfile profile;
}
