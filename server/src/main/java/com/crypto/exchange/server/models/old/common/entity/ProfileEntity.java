package com.crypto.exchange.server.models.old.common.entity;


import com.crypto.exchange.server.models.old.common.Contributor;
import com.crypto.exchange.server.models.old.common.Link;
import com.crypto.exchange.server.models.old.common.RoadMapItem;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "asset_profiles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileEntity {

    @Id
    @Column(name = "asset_name", unique = true)
    String assetName;

    @Column(name = "symbol")
    String symbol;

    @Column(name = "name")
    String name;

    @Column(name = "slug")
    String slug;

    @Column(name = "tagline")
    String tagline;

    @Column(name = "category")
    String category;

    @Column(name = "sector")
    String sector;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    Set<Link> official_links;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    Set<RoadMapItem> roadmap;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    Set<Contributor> individuals;
}
