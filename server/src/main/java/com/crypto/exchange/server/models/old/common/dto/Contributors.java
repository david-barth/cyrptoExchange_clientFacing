package com.crypto.exchange.server.models.old.common.dto;

import com.crypto.exchange.server.models.old.common.Contributor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contributors {
    Set<Contributor> individuals;
}
