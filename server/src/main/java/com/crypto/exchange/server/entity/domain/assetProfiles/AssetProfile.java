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


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_generalData_id")
    GeneralData general;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_contributorGroup_id")
    Contributors contributors;
}
