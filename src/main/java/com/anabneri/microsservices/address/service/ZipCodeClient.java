package com.anabneri.microsservices.address.service;

import com.anabneri.microsservices.address.model.ZipCodeDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ZipCodeClient", url = "${client.api.url-base}")
public interface ZipCodeClient {

    @CircuitBreaker(name = "zipCodeInfo", fallbackMethod = "fallbackZipCode")
    @GetMapping("/ws/{zipCode}/json/")
    ZipCodeDTO getZipCodeInfo(@RequestParam("zipCode") String zipcode);

    default ZipCodeDTO fallbackZipCode(String zipcode, Throwable t) {
        throw new RuntimeException("Inside circuit breaker fallback method. Error with zipCode: "+ zipcode);
    }

}
