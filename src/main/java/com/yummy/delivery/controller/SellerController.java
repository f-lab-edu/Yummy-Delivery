package com.yummy.delivery.controller;

import com.yummy.delivery.domain.Seller;
import com.yummy.delivery.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerController {

    @Autowired
    SellerService sellerService;

    /* 아이디(이메일) 중복확인 */
    @GetMapping("seller/signup/{email}")
    public void checkSameEmail(@RequestParam("email") String email){
        sellerService.checkSameEmail(email);
    }

    /* 회원가입 */
    @PostMapping("/seller/signup")
    public void signUp(Seller seller) {
        sellerService.checkNullData(seller);    //  회원정보를 모두 기입했는지 확인하는 메서드
        sellerService.checkPasswordLength(seller);  //  비밀번호를 8자리 이상 기입했는지 확인하는 메서드
        sellerService.signUp(seller);
    }
}
