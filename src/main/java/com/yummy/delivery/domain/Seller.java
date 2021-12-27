package com.yummy.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Seller {

    private long id;

    private String email;

    private String password;

    private String phone;

    private String address;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;
}