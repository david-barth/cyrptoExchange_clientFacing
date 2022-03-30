package com.crypto.exchange.server.entity.domain.assetProfiles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "assetoverviews")
public class Overview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int ID;

    @Column(name = "tagline")
    String tagline;

    @Column(name = "category")
    String category;

    @Column(name = "sector")
    String sector;

    @Column(name = "project_details")
    String project_details;

    @OneToMany(fetch = FetchType.LAZY)
    List<Link> official_links;
}
