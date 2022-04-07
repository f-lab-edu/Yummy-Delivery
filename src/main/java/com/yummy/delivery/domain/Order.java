package com.yummy.delivery.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class Order {

    private Long id;

    private Long userId;

    private Long storeId;

    private String payType;

    private int totalType;

    private String address;

    private LocalDateTime createdAt;

}
