package com.yummy.delivery.seller.controller;

import com.yummy.delivery.seller.dto.LoginSellerRequest;
import com.yummy.delivery.seller.service.LoginSellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/sellers")
@RestController
public class LoginSellerController {

    private final LoginSellerService loginSellerService;

    @PostMapping("/login")
    public void login(@Valid @RequestBody LoginSellerRequest loginSellerRequest) {
        loginSellerService.login(loginSellerRequest);
    }

    @GetMapping("/logout")
    public void logout() {
        loginSellerService.logoutSeller();
    }
}
