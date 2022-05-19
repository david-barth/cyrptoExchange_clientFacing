package com.crypto.exchange.server.models.old.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roadmap_items")
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
