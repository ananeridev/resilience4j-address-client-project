package com.anabneri.microsservices.productcatalog.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

/*
*
* */

@Configuration
public class OrderConfig {

    private static final String baseUrl = "http://localhost:8086/products";

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        UriTemplateHandler uriTemplateHandler = new RootUriTemplateHandler(baseUrl);
        return builder
            .uriTemplateHandler(uriTemplateHandler)
            .build();
    }

}
