package com.yummy.delivery.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateCartRequest {
  private final Long userId;
  private final Long menuId;
  private final Long storeId;
  private final Integer count;
}