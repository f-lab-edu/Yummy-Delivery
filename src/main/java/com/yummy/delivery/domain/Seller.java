package com.yummy.delivery.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Seller {

    private int id;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
