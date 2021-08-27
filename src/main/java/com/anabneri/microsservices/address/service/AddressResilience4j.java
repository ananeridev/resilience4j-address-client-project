package com.anabneri.microsservices.address.service;

import com.anabneri.microsservices.address.model.ZipCodeDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;

@Component
@RequiredArgsConstructor
public class AddressResilience4j {

    Logger logger = LoggerFactory.getLogger(AddressResilience4j.class);

    private final RestTemplate restTemplate;

    @CircuitBreaker(name = "service1", fallbackMethod = "fallbackForRegisterSeller")
    //@RateLimiter(name = "service1", fallbackMethod = "rateLimiterfallback")
    //@Retry(name = "retryService1", fallbackMethod = "retryfallback")
    //@Bulkhead(name = "bulkheadService1", fallbackMethod = "bulkHeadFallback")
    public ZipCodeDTO getZipCodeInfo(String zipcode) {
        String url =  format("/ws/%s/json/", zipcode);
        return restTemplate.getForObject(url, ZipCodeDTO.class);
    }

    /*
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
 */

    public ZipCodeDTO fallbackForRegisterSeller(String zipcode, Throwable t) {
        logger.error("Inside circuit breaker fallbackForRegisterSeller, cause - {}", t.toString());
        throw new RuntimeException("Inside circuit breaker fallback method. Some error occurred while calling service for seller registration");
    }
}
