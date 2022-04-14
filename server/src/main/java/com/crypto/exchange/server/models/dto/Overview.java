package com.crypto.exchange.server.models.dto;


import lombok.Data;
import java.util.Set;


@Data
public class Overview {
    String tagline;
    String category;
    String sector;
    Set<Link> official_links;
}
