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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_overview_id")
    Overview overview;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_roadmap_id")
    List<RoadMapItem> roadmap;
}
