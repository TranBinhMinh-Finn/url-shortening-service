package com.finn.urlshorteningservice.models;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
public class Url {
    @NotNull @URL
    private String url;
}
