package com.yummy.delivery.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateOrderRequest {

    @NotBlank
    private String address;

    @NotBlank
    private Long storeId;

    @NotBlank
    private List<MenuPair> menuPairs; // []

    @NotBlank
    private String payType;

    @Data
    @AllArgsConstructor
    public static class MenuPair {

        Long menuId;
        String menuName;
        Integer menuVolume;

    }

}
