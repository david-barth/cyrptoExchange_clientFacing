package com.crypto.exchange.server.models.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
public class RoadMapItem {
    String title;
    String date;
    String type;

}
