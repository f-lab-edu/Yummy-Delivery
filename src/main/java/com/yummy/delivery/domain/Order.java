package com.yummy.delivery.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
  private Integer id;
  private PayType payType;
  private BigDecimal totalPrice;
  private String address;
  private Integer userId;
  private Integer storeId;
  private LocalDateTime createdAt;

  public enum PayType {
    // ?
    현금결제, 카드결제
  }

  public static Order order(
      Integer userId, PayType payType, String address, Integer storeId) {
    // 누가 주문했는지
    // 결제 타입이 되는지
    // 어디로 가야하는지
    // 어느 음식을 주문했는지
    Order order = new Order();
    order.userId = userId;
    order.payType = payType;
    order.address = address;
    order.storeId = storeId;
    order.createdAt = LocalDateTime.now();

    return order;
  }


}

/*

CREATE TABLE IF NOT EXISTS `yummy-delivery`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pay_type` VARCHAR(40) NOT NULL,
  `total_price` INT NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  `store_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_user_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_order_store1_idx` (`store_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `yummy-delivery`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_store1`
    FOREIGN KEY (`store_id`)
    REFERENCES `yummy-delivery`.`store` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)


 */