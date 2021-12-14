package com.yummy.delivery.controller;

import com.yummy.delivery.domain.Seller;
import com.yummy.delivery.domain.User;
import com.yummy.delivery.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/seller/signup")
    public void signUp(Seller seller) {
        sellerService.signUp(seller);
    }
}
