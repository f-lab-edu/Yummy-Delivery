package com.yummy.delivery.dto;

import com.yummy.delivery.domain.Cart;
import com.yummy.delivery.domain.Menu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartResponse {
  private Long id;
  private Long menuId;
  private String menuName;
  private Integer price;
  private String photo;
  private String description;

  private Long storeId;
  private Integer count;
  private BigDecimal totalPrice;
  private LocalDateTime createdAt;

  public static CartResponse create(Cart cart, Menu menu) {
    CartResponse cartResponse = new CartResponse();
    cartResponse.id = cart.getId();
    cartResponse.menuId = cart.getMenuId();
    cartResponse.menuName = menu.getName();
    cartResponse.price = menu.getPrice();
    cartResponse.photo = menu.getPhoto();
    cartResponse.description = menu.getDescription();
    cartResponse.storeId = menu.getStoreId().longValue();
    cartResponse.count = cart.getCount();
    cartResponse.totalPrice = new BigDecimal(menu.getPrice() * cartResponse.getCount());
    cartResponse.createdAt = LocalDateTime.now();

    return cartResponse;
  }
}
