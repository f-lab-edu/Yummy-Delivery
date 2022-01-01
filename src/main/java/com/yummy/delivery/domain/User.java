package com.yummy.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class User {

    private Long id;

    private String email;

    private String password;

    private String name;

    private String phone;

    private String address;

}