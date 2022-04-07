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
@Table(name = "generaldata")
public class GeneralData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int ID;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "overview_id")
    Overview overview;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @org.hibernate.annotations.Fetch(FetchMode.SELECT)
    @JoinColumn(name = "generaldata_id")
    Set<RoadMapItem> roadmap;
}
