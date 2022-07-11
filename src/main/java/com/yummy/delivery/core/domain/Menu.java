package com.yummy.delivery.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;
  private Long storeId;

  private String name;
  private BigDecimal price;
  private String photo;
  private String description;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
