package com.yummy.delivery.service;

import com.yummy.delivery.domain.Order;
import com.yummy.delivery.domain.OrderStatus;
import com.yummy.delivery.dto.CreateOrderRequest;
import com.yummy.delivery.dto.CreatePaymentRequest;
import com.yummy.delivery.mapper.OrderMapper;
import com.yummy.delivery.mapper.OrderStatusMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderService {
  private final OrderMapper orderMapper;
  private final OrderStatusMapper orderStatusMapper;

  public void order(CreateOrderRequest createOrderRequest) {
    Order order = Order.order(
        createOrderRequest.getUserId(),
        createOrderRequest.getPayType(),
        createOrderRequest.getAddress(),
        createOrderRequest.getStoreId()
    );
    // insert for order id
    int lastInsertedId = orderMapper.insert(order);
    order.setId(lastInsertedId);

    OrderStatus orderStatus = OrderStatus.order(order);
    // insert
    orderStatusMapper.insert(orderStatus);
  }

  public void cancelOrder(Integer orderId) {

  }

  public void payment(CreatePaymentRequest createPaymentRequest) {
    Order order = orderMapper.findById(createPaymentRequest.getOrderId());
    OrderStatus orderStatus = orderStatusMapper.findByOrderId(order.getId());
    orderStatus.payment();
    orderStatusMapper.update(orderStatus);
  }

  public void cooking(Integer orderId) {

  }

  public void completeDelivery(Integer orderId) {

  }
}
