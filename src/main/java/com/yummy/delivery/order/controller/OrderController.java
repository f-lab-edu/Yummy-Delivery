package com.yummy.delivery.order.controller;

import com.yummy.delivery.annotation.LoginUser;
import com.yummy.delivery.order.dto.CreateOrderRequest;
import com.yummy.delivery.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/orders")
@RestController
public class OrderController {

    private final OrderService orderService;

    @LoginUser
    @PostMapping("/register")
    public void create(@RequestBody CreateOrderRequest createOrderRequest) {
        orderService.create(createOrderRequest);
    }

}
