package com.crypto.exchange.server.entity.domain.assetProfiles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "assetProfiles")
public class AssetProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int ID;

    @Column(name = "FK_generalData_id")
    @OneToOne(fetch = FetchType.LAZY)
    GeneralData general;

    @Column(name = "contributors_id")
    @OneToOne(fetch = FetchType.LAZY)
    Contributors contributors;
}
