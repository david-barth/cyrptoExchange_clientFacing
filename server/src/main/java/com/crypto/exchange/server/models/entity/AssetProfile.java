package com.crypto.exchange.server.models.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "asset_profiles")
@Data
public class AssetProfile {

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

    @OneToMany
    @JoinColumn(name = "profile_id")
    Set<Link> official_links;

    @OneToMany
    @JoinColumn(name = "profile_id")
    Set<RoadMapItem> roadmap;

    @OneToMany
    @JoinColumn(name = "profile_id")
    Set<Contributor> individuals;
}
