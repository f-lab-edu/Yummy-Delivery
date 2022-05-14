package com.yummy.delivery.controller;

import com.yummy.delivery.dto.CreateOrderRequest;
import com.yummy.delivery.dto.CreatePaymentRequest;
import com.yummy.delivery.service.OrderService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {
  private final OrderService orderService;

  @PostMapping("/order")
  public void order(@RequestBody CreateOrderRequest createOrderRequest) {
    orderService.order(createOrderRequest);
  }

  @PostMapping("/order/payment")
  public void payment(@RequestBody CreatePaymentRequest createPaymentRequest) {
    orderService.payment(createPaymentRequest);
  }
}
