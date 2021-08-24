package com.anabneri.microsservices.productcatalog.controller;

import com.anabneri.microsservices.productcatalog.model.SellerProductDto;
import com.anabneri.microsservices.productcatalog.service.UserCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserCatalogController {

    private final UserCatalogService userCatalogService;

    @PostMapping("/register/seller")
    public String registerAsSeller(@RequestBody SellerProductDto sellerDto) {
        return userCatalogService.userCatalogSeller(sellerDto);
    }

    @GetMapping("/sellerList")
    public List<SellerProductDto> getSellersList() {
        return userCatalogService.getSellersList();
    }

}
