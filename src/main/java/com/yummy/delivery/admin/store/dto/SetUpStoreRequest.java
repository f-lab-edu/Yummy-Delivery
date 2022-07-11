package com.yummy.delivery.admin.store.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SetUpStoreRequest {
  private Long sellerId;
  private String name;
  private String phone;
  private String address;
  private String category;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

}