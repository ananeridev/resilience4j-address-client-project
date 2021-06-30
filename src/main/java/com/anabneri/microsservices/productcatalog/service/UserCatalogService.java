package com.anabneri.microsservices.productcatalog.service;

import com.anabneri.microsservices.productcatalog.model.SellerProductDto;

import java.util.List;

public interface UserCatalogService {

    String userCatalogSeller(SellerProductDto sellerDto);

    List<SellerProductDto> getSellersList();
}
