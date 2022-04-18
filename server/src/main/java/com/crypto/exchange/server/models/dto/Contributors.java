package com.crypto.exchange.server.models.dto;

import com.crypto.exchange.server.models.common.Contributor;
import lombok.Data;
import java.util.Set;

@Data
public class Contributors {
    Set<Contributor> individuals;
}
