package com.yummy.delivery.domailn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class User {

    private final long id;

    private final String email;

    private final String password;

    private final String name;

    private final String phone;

    private final String address;

}