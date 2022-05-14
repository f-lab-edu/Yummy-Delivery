package com.yummy.delivery.dto;

import com.yummy.delivery.domain.Order;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateOrderRequest {
  private final Integer userId;
  private final Order.PayType payType;
  private final String address;
  private final Integer storeId;
}

/*

주문 및 결제 기능
배달 주문 기능
배달 주문 취소 기능
배달 음식 결제 기능

 */