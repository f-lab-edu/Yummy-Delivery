package com.yummy.delivery.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartRequestDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Long storeId;

    @NotNull
    private Long menuId;

    @NotNull
    private Integer count;

}
