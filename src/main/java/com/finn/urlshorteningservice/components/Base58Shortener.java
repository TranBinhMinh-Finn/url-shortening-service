package com.finn.urlshorteningservice.components;

import com.finn.urlshorteningservice.utils.Base58Encoder;
import com.finn.urlshorteningservice.utils.StringConverter;
import org.springframework.stereotype.Component;

@Component
public class Base58Shortener implements UrlShortener {
    @Override
    public String shorten(String url) {
        return Base58Encoder.encode(
                StringConverter.convertByAsciiToDecimal(url)
        );

    }
}
