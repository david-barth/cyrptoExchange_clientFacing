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
@Table(name = "generaldata")
public class GeneralData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int ID;

    @Column(name = "FK_overview_id")
    @OneToOne(fetch = FetchType.LAZY)
    Overview overview;

    @Column(name = "FK_roadmap_id")
    @OneToMany(fetch = FetchType.LAZY)
    List<RoadMapItem> roadmap;
}
