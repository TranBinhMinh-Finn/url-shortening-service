package com.finn.urlshorteningservice.controllers;

import com.finn.urlshorteningservice.services.UrlShorteningService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shorten")
public class UrlShorteningController {

    private final UrlShorteningService urlShorteningService;

    public UrlShorteningController(UrlShorteningService urlShorteningService) {
        this.urlShorteningService = urlShorteningService;
    }

    @PostMapping
    public String shortenUrl(@RequestBody final String url) {
        return urlShorteningService.shortenUrl(url);
    }
}
