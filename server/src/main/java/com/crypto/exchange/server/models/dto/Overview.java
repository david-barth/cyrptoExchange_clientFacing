package com.crypto.exchange.server.models.dto;


import com.crypto.exchange.server.models.common.Link;
import lombok.Builder;
import lombok.Data;
import java.util.Set;


@Data
@Builder
public class Overview {
    String tagline;
    String category;
    String sector;
    Set<Link> official_links;
}
