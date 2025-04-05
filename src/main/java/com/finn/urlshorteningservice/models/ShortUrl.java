package com.finn.urlshorteningservice.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
public class ShortUrl {
    @Id
    private long id;

    private String url;
    private String shortCode;

    // private Timestamp created;
    // private Timestamp lastUpdated;
}
