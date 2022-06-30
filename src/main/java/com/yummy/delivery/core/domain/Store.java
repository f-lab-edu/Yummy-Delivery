package com.yummy.delivery.core.domain;

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
public class Store {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  private Long sellerId;
  private String name;
  private String phone;
  private String address;
  private String category; // TODO enum
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

/*
CREATE TABLE IF NOT EXISTS `yummy-delivery`.`seller` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(40) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
* */
}
