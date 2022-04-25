package com.crypto.exchange.server.models.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "contributors")
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
