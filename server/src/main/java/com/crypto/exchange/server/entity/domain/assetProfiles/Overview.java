package com.crypto.exchange.server.entity.domain.assetProfiles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @org.hibernate.annotations.Fetch(FetchMode.SELECT)
    @JoinColumn(name = "assetoverview_id")
    Set<Link> official_links;
}
