package com.finn.urlshorteningservice.components;

import com.finn.urlshorteningservice.utils.Base58Encoder;
import com.finn.urlshorteningservice.utils.StringConverter;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class Base58Shortener implements UrlShortener {
    @Override
    public String shorten(long id) {
        return Base58Encoder.encode(BigInteger.valueOf(id));

    }
}
