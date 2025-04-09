package com.finn.urlshorteningservice.repositories;

import com.finn.urlshorteningservice.models.ShortUrl;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ShortUrlRepository extends CrudRepository<ShortUrl, Long> {
    @Query("SELECT * FROM short_url WHERE short_code=:shortCode")
    Optional<ShortUrl> getShortUrlByShortCode(String shortCode);

    @Modifying
    @Query("DELETE FROM short_url WHERE short_code=:shortCode")
    Integer deleteShortUrlByShortCode(String shortCode);

}
