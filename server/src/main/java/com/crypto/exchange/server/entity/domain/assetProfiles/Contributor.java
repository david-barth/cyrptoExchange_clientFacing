package com.crypto.exchange.server.entity.domain.assetProfiles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "contributors")
public class Contributor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @ManyToOne
    @JoinColumn(name = "FK_contributorGroup_id")
    Contributors contributorGroup;

    @Column(name = "slug")
    String slug;

    @Column(name = "first_name")
    String first_name;

    @Column(name = "last_name")
    String last_name;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "avatar_url")
    String avatar_url;
}
