package com.yummy.delivery.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class Cart {

    private Long id;

    private Long userId;

    private Long menuId;

    private Long storeId;

    private Integer count;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static Cart create(Long userId, Long menuId, Long storeId, Integer count) {
      Cart cart = new Cart();

      cart.userId = userId;
      cart.menuId = menuId;
      cart.storeId = storeId;
      cart.count = count;

      return cart;
    }


}
