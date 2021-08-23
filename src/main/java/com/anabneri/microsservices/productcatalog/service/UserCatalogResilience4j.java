package com.anabneri.microsservices.productcatalog.service;

import com.anabneri.microsservices.productcatalog.model.SellerProductDto;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserCatalogResilience4j {

    Logger logger = LoggerFactory.getLogger(UserCatalogResilience4j.class);

    private final RestTemplate restTemplate;

    @CircuitBreaker(name = "service1", fallbackMethod = "fallbackForRegisterSeller")
    @RateLimiter(name = "service1", fallbackMethod = "rateLimiterfallback")
    @Retry(name = "retryService1", fallbackMethod = "retryfallback")
    @Bulkhead(name = "bulkheadService1", fallbackMethod = "bulkHeadFallback")
    public String registerSeller(SellerProductDto sellerDto) {
        String response = restTemplate.postForObject("/addSeller", sellerDto, String.class);
        return response;
    }

    @CircuitBreaker(name = "service2", fallbackMethod = "fallbackForGetSeller")
    public List<SellerProductDto> getSellersList() {
        logger.info("calling getSellerList()");
        return restTemplate.getForObject("/sellersList", List.class);
    }


    public String rateLimiterfallback(SellerProductDto sellerDto, Throwable t) {
        logger.error("Inside rateLimiterfallback, cause - {}", t.toString());
        return "Inside rateLimiterfallback method. Some error occurred while calling service for seller registration";
    }


    public String bulkHeadFallback(SellerProductDto sellerDto, Throwable t) {
        logger.error("Inside bulkHeadFallback, cause - {}", t.toString());
        return "Inside bulkHeadFallback method. Some error occurred while calling service for seller registration";
    }


    public String retryfallback(SellerProductDto sellerDto, Throwable t) {
        logger.error("Inside retryfallback, cause - {}", t.toString());
        return "Inside retryfallback method. Some error occurred while calling service for seller registration";
    }


    public String fallbackForRegisterSeller(SellerProductDto sellerDto, Throwable t) {
        logger.error("Inside circuit breaker fallbackForRegisterSeller, cause - {}", t.toString());
        return "Inside circuit breaker fallback method. Some error occurred while calling service for seller registration";
    }


    public List<SellerProductDto> fallbackForGetSeller(Throwable t) {
        logger.error("Inside fallbackForGetSeller, cause - {}", t.toString());
        SellerProductDto sd = new SellerProductDto();
        sd.setFirstName("AnaNeri");
        sd.setId(1234);
        sd.setEmailId("default");
        List<SellerProductDto> defaultList = new ArrayList<>();
        defaultList.add(sd);
        return defaultList;
    }

}
