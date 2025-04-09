package com.finn.urlshorteningservice.services;

import com.finn.urlshorteningservice.exceptions.ShortCodeNotFoundException;
import com.finn.urlshorteningservice.models.ShortUrl;
import com.finn.urlshorteningservice.repositories.ShortUrlRepository;
import com.finn.urlshorteningservice.components.UrlShortener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public ShortUrl shortenUrl(String url) {
        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setUrl(url);

        ShortUrl savedUrl = shortUrlRepository.save(shortUrl);

        String shortCode = urlShortener.shorten(savedUrl.getId());

        savedUrl.setShortCode(shortCode);
        shortUrlRepository.save(savedUrl);

        return savedUrl;
    }

    public ShortUrl getShortUrl(String shortCode) {
        return shortUrlRepository
                .getShortUrlByShortCode(shortCode)
                .orElseThrow(ShortCodeNotFoundException::new);
    }

    public ShortUrl updateShortUrl(String shortCode, String url) {
        ShortUrl urlInDb = shortUrlRepository
                .getShortUrlByShortCode(shortCode)
                .orElseThrow(ShortCodeNotFoundException::new);
        urlInDb.setUrl(url);
        return shortUrlRepository.save(urlInDb);
    }

    public void deleteShortUrl(String shortCode) {
        Integer result = shortUrlRepository.deleteShortUrlByShortCode(shortCode);
        if (result == 0) {
            throw new ShortCodeNotFoundException();
        }
    }

}
