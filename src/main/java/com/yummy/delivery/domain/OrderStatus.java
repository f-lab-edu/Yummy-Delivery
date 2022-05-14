package com.yummy.delivery.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderStatus {
  private Integer id;
  private Integer orderId;

  private Status status;
  private LocalDateTime updatedAt;

  public void payment() {
    if (status != Status.결제_대기) {
      throw new IllegalArgumentException("결제 대기상태가 아닙니다.");
    }
    status = Status.조리_중;
  }

  public enum Status {
    // 결제_대기 -> 데이터 생기고 // User
    // 결제 완료 -> 조리중 // User
    // 조리 완료 후 -> 배달중 // Seller
    // 배달완료 후 -> 배달 완료 // Rider
    결제_대기, 조리_중, 배달_중, 배달_완료
  }

  public static OrderStatus order(Order order) {
    OrderStatus orderStatus = new OrderStatus();
    orderStatus.orderId = order.getId();
    orderStatus.status = Status.결제_대기;
    orderStatus.updatedAt = LocalDateTime.now();
    return orderStatus;
  }
}

/*

CREATE TABLE IF NOT EXISTS `yummy-delivery`.`order_status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(40) NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `order_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_status_order1_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_status_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `yummy-delivery`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)

* */