package com.crypto.exchange.server.models.old.common.dto;


import com.crypto.exchange.server.models.old.common.Link;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Overview {
    String tagline;
    String category;
    String sector;
    Set<Link> official_links;
}
