package com.crypto.exchange.server.entity.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Contributors {
    List<Contributor> individuals;
}