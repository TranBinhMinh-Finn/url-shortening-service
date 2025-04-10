package com.finn.urlshorteningservice.components;

import com.finn.urlshorteningservice.dto.ShortUrlDto;
import com.finn.urlshorteningservice.dto.ShortUrlStatsDto;
import com.finn.urlshorteningservice.models.ShortUrl;
import org.springframework.stereotype.Component;

@Component
public class ShortUrlMapper {

    public ShortUrlDto entityToDto(ShortUrl shortUrl) {
        return ShortUrlDto.builder()
                .id(shortUrl.getId())
                .shortCode(shortUrl.getShortCode())
                .url(shortUrl.getUrl())
                .createdAt(shortUrl.getCreatedAt())
                .updatedAt(shortUrl.getUpdatedAt())
                .build();
    }

    public ShortUrlStatsDto entityToStatsDto(ShortUrl shortUrl) {
        return ShortUrlStatsDto.builder()
                .id(shortUrl.getId())
                .shortCode(shortUrl.getShortCode())
                .url(shortUrl.getUrl())
                .createdAt(shortUrl.getCreatedAt())
                .updatedAt(shortUrl.getUpdatedAt())
                .accessCount(shortUrl.getAccessCount())
                .build();
    }
}
