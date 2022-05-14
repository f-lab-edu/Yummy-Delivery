package com.yummy.delivery.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreatePaymentRequest {
  private final Integer userId;
  private final Integer orderId;
}
