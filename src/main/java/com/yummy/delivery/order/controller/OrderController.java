package com.yummy.delivery.order.controller;

import com.yummy.delivery.annotation.LoginUser;
import com.yummy.delivery.order.dto.CancelOrder;
import com.yummy.delivery.order.dto.ConfirmOrder;
import com.yummy.delivery.order.dto.CreateOrderRequest;
import com.yummy.delivery.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @LoginUser
    @DeleteMapping("/cancel")
    public void cancel(@RequestBody CancelOrder cancelOrder) {
        orderService.cancel(cancelOrder);
    }

    @LoginUser
    @PostMapping("/confirm")
    public void confirm(@Valid @RequestBody ConfirmOrder confirmOrder) {
        orderService.confirm(confirmOrder);
    }

}
