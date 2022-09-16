package com.yummy.delivery.seller.controller;

import com.yummy.delivery.annotation.LoginSeller;
import com.yummy.delivery.order.dto.ResponseOrder;
import com.yummy.delivery.order.service.SellerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/seller/order")
@RestController
public class OrderSellerController {

    private final SellerOrderService sellerOrderService;

    @LoginSeller
    @PostMapping("/response")
    public void response(@Valid @RequestBody ResponseOrder responseOrder) {
        sellerOrderService.responseOrder(responseOrder);
    }

}
