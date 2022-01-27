package com.yummy.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class Store {

    private Long id;

    private Long sellerId;

    private String name;

    private String phone;

    private String address;

    private String category;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
