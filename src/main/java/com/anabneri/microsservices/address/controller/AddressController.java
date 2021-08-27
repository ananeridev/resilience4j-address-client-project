package com.anabneri.microsservices.address.controller;

import com.anabneri.microsservices.address.model.ZipCodeDTO;
import com.anabneri.microsservices.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/address", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/{zipcode}")
    public ResponseEntity<ZipCodeDTO> getZipCodeInformation(@PathVariable String zipcode) {
        var response = addressService.getZipCodeInfo(zipcode);
        return ResponseEntity.ok(response);
    }
}
