package com.finn.urlshorteningservice.controllers;

import com.finn.urlshorteningservice.models.ShortUrl;
import com.finn.urlshorteningservice.services.UrlShorteningService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shorten")
public class UrlShorteningController {

    private final UrlShorteningService urlShorteningService;

    public UrlShorteningController(UrlShorteningService urlShorteningService) {
        this.urlShorteningService = urlShorteningService;
    }

    @PostMapping
    public String shortenUrl(@RequestBody ShortUrl shortUrl) {
        return urlShorteningService.shortenUrl(shortUrl);
    }

    @GetMapping
    public List<ShortUrl> getShortUrl(@RequestBody ShortUrl shortUrl) {
        return urlShorteningService.getShortUrl(shortUrl);
    }
}
