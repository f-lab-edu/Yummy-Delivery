package com.yummy.delivery.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.DateTimeException;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class User {

    private int id;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
