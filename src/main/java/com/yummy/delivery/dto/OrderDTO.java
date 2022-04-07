package com.yummy.delivery.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderDTO {

    private Long id;

    private Long userId;

    private Long storeId;

    private String address;

    private String payType;

    private Long totalPrice;

    private LocalDateTime createdAt;

}
