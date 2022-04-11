package com.crypto.exchange.server.entity.domain.assetProfiles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asset_on_record")
public class AssetOnRecord {
    @Id
    @Column(name = "asset_name")
    String assetName;
}
