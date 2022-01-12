package com.yummy.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Seller {

    private Long id;

    private String email;

    private String password;

    private String phone;

    private String address;
}

