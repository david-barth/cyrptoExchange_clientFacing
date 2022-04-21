package com.crypto.exchange.server.models.dto;

import lombok.*;


@Data
@Builder
//Continuation:  Fix DTO in order to allow for proper functioning of endpoint
public class Profile {
    private ProfileData data;
}
