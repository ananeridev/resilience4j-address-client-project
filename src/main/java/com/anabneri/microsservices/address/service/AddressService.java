package com.anabneri.microsservices.address.service;

import com.anabneri.microsservices.address.model.ZipCodeDTO;

public interface AddressService {

    ZipCodeDTO getZipCodeInfo(String zipcode);
}
