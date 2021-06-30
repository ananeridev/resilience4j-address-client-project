package com.anabneri.microsservices.productcatalog.service;

import com.anabneri.microsservices.productcatalog.model.SellerProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCatalogServiceImpl implements UserCatalogService{

    Logger logger = LoggerFactory.getLogger(UserCatalogServiceImpl.class);
    private UserCatalogResilience4j userCatalogResilience4j;


    public UserCatalogServiceImpl(UserCatalogResilience4j userCatalogResilience4j) {
        this.userCatalogResilience4j = userCatalogResilience4j;
    }

    public String catalogSeller(SellerProductDto sellerDto) {

        String catalogSeller = null;

        long start = System.currentTimeMillis();

        catalogSeller = userCatalogResilience4j.registerSeller(sellerDto);

        logger.info("add seller call returned in - {}", System.currentTimeMillis() - start);

        return catalogSeller;

    }

    @Override
    public String userCatalogSeller(final SellerProductDto sellerDto) {
        return null;
    }

    @Override
    public List<SellerProductDto> getSellersList() {
        return userCatalogResilience4j.getSellersList();
    }
}
