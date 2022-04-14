package com.crypto.exchange.server.models.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "contributors")
public class Contributor {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;

    @Column(name = "slug")
    String slug;

    @Column(name = "first_name")
    String first_name;

    @Column(name = "last_name")
    String last_name;

    @Column(name = "title")
    String title;

    @Column(name = "avatar_url")
    String avatar_url;
}
