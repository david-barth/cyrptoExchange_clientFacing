package com.crypto.exchange.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Quote {

    @Getter
    @Setter
    @JsonProperty("name")
    private String assetName;
}
