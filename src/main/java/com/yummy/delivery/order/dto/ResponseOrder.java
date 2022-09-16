package com.yummy.delivery.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResponseOrder {

    @NotBlank
    private Long orderId;

    @NotNull
    private Boolean isAccepted;
}
