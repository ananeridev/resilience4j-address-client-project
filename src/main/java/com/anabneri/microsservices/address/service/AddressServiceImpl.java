package com.anabneri.microsservices.address.service;

import com.anabneri.microsservices.address.model.ZipCodeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

    private final AddressResilience4j addressResilience4j;

    @Override
    public ZipCodeDTO getZipCodeInfo(final String zipCode) {
        return addressResilience4j.getZipCodeInfo(zipCode);
    }

}
