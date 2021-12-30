package com.yummy.delivery.domailn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Seller {

    private final long id;

    private final String email;

    private final String password;

    private final String phone;

    private final String address;
}