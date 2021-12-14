package com.yummy.delivery.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Seller {

    private int id;
    private String email;
    private String password;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
