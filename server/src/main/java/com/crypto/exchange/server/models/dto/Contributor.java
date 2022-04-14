package com.crypto.exchange.server.models.dto;

import lombok.Data;


@Data
public class Contributor {
    String slug;
    String first_name;
    String last_name;
    String title;
    String avatar_url;
}
