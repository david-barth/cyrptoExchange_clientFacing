package com.crypto.exchange.server.entity.domain.assetProfiles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Contributor {
    String slug;
    String first_name;
    String last_name;
    String title;
    String description;
    String avatar_url;
}
