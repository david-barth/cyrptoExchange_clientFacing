package com.crypto.exchange.server.entity.domain.assetProfiles;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany(mappedBy = "contributors", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Contributor> individuals;

}
