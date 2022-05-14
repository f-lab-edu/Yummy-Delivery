package com.yummy.delivery.service;

import com.yummy.delivery.domain.Order;
import com.yummy.delivery.domain.OrderStatus;

import org.junit.Test;
import org.spockframework.util.Pair;

import static org.junit.Assert.assertEquals;

public class OrderServiceTest {
  OrderService orderService;

  @Test
  public void 배달_주문() {
    // 주문
    // given
    Integer userId = 10;
    Order.PayType payType = Order.PayType.카드결제;
    String address = "경기도 광주시 태전동";
    Integer storeId = 20;

    // when
    Pair<Order, OrderStatus> createdPair = createOrderPair(userId, payType, address, storeId);
    Order createdOrder = createdPair.first();
    OrderStatus createdOrderStatus = createdPair.second();

    // then
    System.out.println(createdOrder);
    System.out.println(createdOrderStatus);

    assertEquals(createdOrder.getUserId(), userId);
    assertEquals(createdOrderStatus.getOrderId(), createdOrder.getId());
  }

  @Test
  public void 배달_주문_취소() {
    // 주문
  }

  @Test
  public void 배달_음식_결제() {
    // 결제했을때 OrderStatus 변경
  }

  // 결제_대기, 조리_중, 배달_중, 배달_완료
  @Test
  public void 결제_완료() {
    // 주문
    // given
    Integer userId = 10;
    Order.PayType payType = Order.PayType.카드결제;
    String address = "경기도 광주시 태전동";
    Integer storeId = 20;

    Pair<Order, OrderStatus> createdPair = createOrderPair(userId, payType, address, storeId);
    OrderStatus orderStatus = createdPair.second();

    // when
    orderStatus.payment();

    System.out.println(orderStatus);
    assertEquals(orderStatus.getStatus(), OrderStatus.Status.조리_중);
  }

  @Test
  public void 결제_완료_잘못된요청() {
    // 주문
    // given
    Integer userId = 10;
    Order.PayType payType = Order.PayType.카드결제;
    String address = "경기도 광주시 태전동";
    Integer storeId = 20;

    Pair<Order, OrderStatus> createdPair = createOrderPair(userId, payType, address, storeId);
    OrderStatus orderStatus = createdPair.second();
    orderStatus.setStatus(OrderStatus.Status.배달_완료);

    // when
    orderStatus.payment();

    // 오류 발생 잡는방법
  }

  // 결제_대기, 조리_중, 배달_중, 배달_완료
  @Test
  public void 조리_완료() {

  }


  // 결제_대기, 조리_중, 배달_중, 배달_완료
  @Test
  public void 배달_완료() {

  }

  private Pair<Order, OrderStatus> createOrderPair(Integer userId, Order.PayType payType,
                                                   String address, Integer storeId) {
    Order createdOrder = Order.order(userId, payType, address, storeId);
    OrderStatus createdOrderStatus = OrderStatus.order(createdOrder);

    return Pair.of(createdOrder, createdOrderStatus);
  }
}
