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
@Table(name = "contributorgroups")
public class Contributors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;


    //Continuation: Need to figure out how to have Hibernate refer to a pre-existing foreign key rather than creating a key with @JoinColumn
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "contributorGroup_id", insertable = false, updatable = false)
    List<Contributor> individuals;
}
