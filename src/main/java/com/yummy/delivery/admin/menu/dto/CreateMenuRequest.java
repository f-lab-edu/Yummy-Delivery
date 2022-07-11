package com.yummy.delivery.admin.menu.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMenuRequest {
  private Long storeId;
  private String name;
  private BigDecimal price;
  private String photo; // TODO multipart
  private String description;
}