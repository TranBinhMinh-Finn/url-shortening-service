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

    private Timestamp createdAt;
    private Timestamp updatedAt;

    private long accessCount;

    public ShortUrl() {
        this.accessCount = 0;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
