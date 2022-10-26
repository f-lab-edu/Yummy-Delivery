package com.yummy.delivery.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateOrderRequest {

    @NotBlank
    private String address;

    @NotBlank
    private Long storeId;

    @NotBlank
    private List<MenuPair> menuPairs;

    @NotBlank
    private String payType;

    private Set<Long> couponTicketIds;

    @Data
    @AllArgsConstructor
    public static class MenuPair {

        Long menuId;
        String menuName;
        BigDecimal menuVolume;

    }

}
