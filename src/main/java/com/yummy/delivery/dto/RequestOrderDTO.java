package com.yummy.delivery.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class RequestOrderDTO {

    private Long id;

    private Long userId;

    private Long storeId;

    private String payType;

    private int totalPrice;

    private String address;

}
