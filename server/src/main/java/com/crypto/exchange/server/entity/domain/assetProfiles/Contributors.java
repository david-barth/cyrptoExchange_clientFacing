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
@Table(name = "contributorgroups")
public class Contributors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @org.hibernate.annotations.Fetch(FetchMode.SELECT)
    @JoinColumn(name = "contributor_group_id")
    Set<Contributor> individuals;
}
