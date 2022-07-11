package com.yummy.delivery.admin.store.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindStoreResponse {
  private Long sellerId; // TODO 셀러정보 ex 이름 등
  private String storeName;
  private String storeContact;
  private String storeAddress;
  private String thumbnailUrl;
  // TODO menu
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

}
