package com.yummy.delivery.controller;

import com.yummy.delivery.dto.SellerDTO;
import com.yummy.delivery.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.yummy.delivery.httpStatus.httpComponent.RESPONSE_ENTITY_OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sellers")
public class SellerController {

    private final SellerService sellerService;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody SellerDTO sellerDTO) {
        sellerService.login(sellerDTO);
        return RESPONSE_ENTITY_OK;
    }

    @GetMapping("/logout")
    public ResponseEntity<Void> logout() {
        sellerService.logout();
        return RESPONSE_ENTITY_OK;
    }

    @PutMapping("/mypage")
    public ResponseEntity<Void> updateSeller(@RequestBody SellerDTO sellerDTO) {
        sellerService.updateSeller(sellerDTO);
        return RESPONSE_ENTITY_OK;
    }
}