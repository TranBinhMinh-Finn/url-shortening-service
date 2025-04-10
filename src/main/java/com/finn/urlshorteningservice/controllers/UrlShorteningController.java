package com.finn.urlshorteningservice.controllers;

import com.finn.urlshorteningservice.dto.ShortUrlDto;
import com.finn.urlshorteningservice.dto.ShortUrlStatsDto;
import com.finn.urlshorteningservice.models.ShortUrl;
import com.finn.urlshorteningservice.models.Url;
import com.finn.urlshorteningservice.services.UrlShorteningService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ShortUrlDto> shortenUrl(@Valid @RequestBody Url url) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(urlShorteningService.shortenUrl(url.getUrl()));
    }

    @GetMapping("/{shortCode}")
    public ShortUrlDto getShortUrl(@PathVariable(required = true) String shortCode) {
        return urlShorteningService.getDtoByShortCode(shortCode);
    }

    @GetMapping("/{shortCode}/stats")
    public ShortUrlStatsDto getStatsDtoByShortCode(@PathVariable(required = true) String shortCode) {
        return urlShorteningService.getStatsDtoByShortCode(shortCode);
    }

    @PatchMapping("/{shortCode}")
    public ShortUrlDto updateShortUrl(@PathVariable(required = true) String shortCode, @Valid @RequestBody Url url) {
        return urlShorteningService.updateShortUrl(shortCode, url.getUrl());
    }

    @DeleteMapping("/{shortCode}")
    public ResponseEntity<String> deleteShortUrl(@PathVariable(required = true) String shortCode) {
        urlShorteningService.deleteShortUrl(shortCode);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
