package com.yummy.delivery.seller.controller;

import com.yummy.delivery.annotation.LoginSeller;
import com.yummy.delivery.seller.dto.UpdateSellerRequest;
import com.yummy.delivery.seller.service.ProfileSellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/seller-profiles")
@RestController
public class ProfileSellerController {

    private final ProfileSellerService profileSellerService;

    @LoginSeller
    @PatchMapping("/update")
    public void update(@RequestBody UpdateSellerRequest updateSellerRequest) {
        System.out.println("1");
        profileSellerService.update(updateSellerRequest);
    }

    @DeleteMapping("/withdrawal")
    public void deleteSeller() {
        profileSellerService.delete();
    }


}
