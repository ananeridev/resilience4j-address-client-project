package com.anabneri.microsservices.address.service;

import com.anabneri.microsservices.address.model.ZipCodeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

    private final ZipCodeClient zipCodeClient;

    @Override
    public ZipCodeDTO getZipCodeInfo(final String zipCode) {
        return zipCodeClient.getZipCodeInfo(zipCode);
    }

}
