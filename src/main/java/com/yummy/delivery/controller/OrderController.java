package com.yummy.delivery.controller;

import com.yummy.delivery.dto.RequestOrderDTO;
import com.yummy.delivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public void registerOrder(@RequestBody RequestOrderDTO orderRequestDTO) {
        orderService.registerOrder(orderRequestDTO);
    }
}
