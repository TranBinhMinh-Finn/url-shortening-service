package com.finn.urlshorteningservice.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class ShortUrlStatsDto {
    long id;
    String shortCode;
    String url;
    Timestamp createdAt;
    Timestamp updatedAt;
    long accessCount;
}
