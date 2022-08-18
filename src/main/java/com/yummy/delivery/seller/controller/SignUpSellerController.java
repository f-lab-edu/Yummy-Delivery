package com.yummy.delivery.seller.controller;

import com.yummy.delivery.seller.dto.CreateSellerRequest;
import com.yummy.delivery.seller.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/sellers")
@RestController
public class SignUpSellerController {

    private final SellerService sellerService;

    @PostMapping("/signup")
    public void create(@Valid @RequestBody CreateSellerRequest createSellerRequest) {
        sellerService.signUp(createSellerRequest);
    }



}
