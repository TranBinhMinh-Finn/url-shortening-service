package com.finn.urlshorteningservice.services;

import com.finn.urlshorteningservice.components.ShortUrlMapper;
import com.finn.urlshorteningservice.dto.ShortUrlDto;
import com.finn.urlshorteningservice.dto.ShortUrlStatsDto;
import com.finn.urlshorteningservice.exceptions.ShortCodeNotFoundException;
import com.finn.urlshorteningservice.models.ShortUrl;
import com.finn.urlshorteningservice.repositories.ShortUrlRepository;
import com.finn.urlshorteningservice.components.UrlShortener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UrlShorteningService {

    private final UrlShortener urlShortener;
    private final ShortUrlRepository shortUrlRepository;
    private final ShortUrlMapper shortUrlMapper;

    public UrlShorteningService(UrlShortener urlShortener,
                                ShortUrlRepository shortUrlRepository,
                                ShortUrlMapper shortUrlMapper) {
        this.urlShortener = urlShortener;
        this.shortUrlRepository = shortUrlRepository;
        this.shortUrlMapper = shortUrlMapper;
    }

    @Transactional
    public ShortUrlDto shortenUrl(String url) {
        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setUrl(url);

        ShortUrl savedUrl = shortUrlRepository.save(shortUrl);
        String shortCode = urlShortener.shorten(savedUrl.getId());

        savedUrl.setShortCode(shortCode);
        shortUrlRepository.save(savedUrl);

        return shortUrlMapper.entityToDto(savedUrl);
    }

    private ShortUrl getShortUrl(String shortCode) {
        ShortUrl shortUrl = shortUrlRepository
                .getShortUrlByShortCode(shortCode)
                .orElseThrow(ShortCodeNotFoundException::new);
        shortUrl.setAccessCount(shortUrl.getAccessCount() + 1);
        shortUrlRepository.save(shortUrl);
        return shortUrl;
    }

    @Transactional
    public ShortUrlDto updateShortUrl(String shortCode, String url) {
        ShortUrl urlInDb = shortUrlRepository
                .getShortUrlByShortCode(shortCode)
                .orElseThrow(ShortCodeNotFoundException::new);
        urlInDb.setUrl(url);
        urlInDb.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return shortUrlMapper.entityToDto(shortUrlRepository.save(urlInDb));
    }

    public void deleteShortUrl(String shortCode) {
        Integer result = shortUrlRepository.deleteShortUrlByShortCode(shortCode);
        if (result == 0) {
            throw new ShortCodeNotFoundException();
        }
    }

    @Transactional
    public ShortUrlDto getDtoByShortCode(String shortCode) {
        return shortUrlMapper.entityToDto(getShortUrl(shortCode));
    }

    @Transactional
    public ShortUrlStatsDto getStatsDtoByShortCode(String shortCode) {
        return shortUrlMapper.entityToStatsDto(getShortUrl(shortCode));
    }

}
