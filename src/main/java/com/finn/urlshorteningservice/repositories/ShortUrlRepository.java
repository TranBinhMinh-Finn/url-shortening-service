package com.finn.urlshorteningservice.repositories;

import com.finn.urlshorteningservice.models.ShortUrl;
import org.springframework.data.repository.CrudRepository;

public interface ShortUrlRepository extends CrudRepository<ShortUrl, Long> {

}
