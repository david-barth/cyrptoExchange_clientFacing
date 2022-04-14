package com.crypto.exchange.server.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roadmap_items")
public class RoadMapItem {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;

    @Column(name = "title")
    String title;

    @Column(name = "date")
    String date;

    @Column(name = "type")
    String type;

}
