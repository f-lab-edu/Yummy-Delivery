package com.yummy.delivery.dto;

import com.yummy.delivery.domain.Cart;
import com.yummy.delivery.domain.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CartResponseDTO {

    private Long id;

    private Long menuId;

    private Long storeId;

    private String menuName;

    private Integer price;

    private String photo;

    private String description;

    private Integer count;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    public static CartResponseDTO create(Cart cart, Menu menu) {
        CartResponseDTO cartResponseDTO = new CartResponseDTO();

        cartResponseDTO.id = cart.getId();
        cartResponseDTO.menuId = cart.getMenuId();
        cartResponseDTO.storeId = cart.getStoreId();
        cartResponseDTO.menuName = menu.getName();
        cartResponseDTO.price = menu.getPrice();
        cartResponseDTO.photo = menu.getPhoto();
        cartResponseDTO.description = menu.getDescription();
        cartResponseDTO.count = cart.getCount();
        cartResponseDTO.totalPrice = new BigDecimal(menu.getPrice() * cartResponseDTO.getCount());
        cartResponseDTO.createdAt = LocalDateTime.now();

        return cartResponseDTO;
    }



}
