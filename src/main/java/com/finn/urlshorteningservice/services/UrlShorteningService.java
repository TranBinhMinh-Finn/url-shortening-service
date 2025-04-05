package com.finn.urlshorteningservice.services;

import com.finn.urlshorteningservice.models.ShortUrl;
import com.finn.urlshorteningservice.repositories.ShortUrlRepository;
import com.finn.urlshorteningservice.components.UrlShortener;
import org.springframework.stereotype.Service;

@Service
public class UrlShorteningService {

    private final UrlShortener urlShortener;
    private final ShortUrlRepository shortUrlRepository;

    public UrlShorteningService(UrlShortener urlShortener,
                                ShortUrlRepository shortUrlRepository) {
        this.urlShortener = urlShortener;
        this.shortUrlRepository = shortUrlRepository;
    }
    public String shortenUrl(String url) {
        String shortCode = urlShortener.shorten(url);

        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setShortCode(shortCode);
        shortUrl.setUrl(url);

        shortUrlRepository.save(shortUrl);
        return shortCode;
    }
}
