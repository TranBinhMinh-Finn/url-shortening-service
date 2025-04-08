package com.finn.urlshorteningservice.services;

import com.finn.urlshorteningservice.models.ShortUrl;
import com.finn.urlshorteningservice.repositories.ShortUrlRepository;
import com.finn.urlshorteningservice.components.UrlShortener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlShorteningService {

    private final UrlShortener urlShortener;
    private final ShortUrlRepository shortUrlRepository;

    public UrlShorteningService(UrlShortener urlShortener,
                                ShortUrlRepository shortUrlRepository) {
        this.urlShortener = urlShortener;
        this.shortUrlRepository = shortUrlRepository;
    }
    public String shortenUrl(ShortUrl shortUrl) {
        String shortCode = urlShortener.shorten(shortUrl.getUrl());

        // ShortUrl shortUrl = new ShortUrl();
        shortUrl.setShortCode(shortCode);
        // shortUrl.setUrl(url);

        shortUrlRepository.save(shortUrl);
        return shortCode;
    }

    public List<ShortUrl> getShortUrl(ShortUrl shortUrl) {
        return shortUrlRepository.getShortUrlsByShortCode(shortUrl.getShortCode());
    }
}
