package com.crypto.exchange.server.models.old.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "links")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;

    @Column(name = "name")
    String name;

    @Column(name = "link")
    String link;
}
