package com.crypto.exchange.server.models.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "links")
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
