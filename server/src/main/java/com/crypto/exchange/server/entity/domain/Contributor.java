package com.crypto.exchange.server.entity.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Contributor {
    String first_name;
    String last_name;
    String title;
    String avatar_url;
}
