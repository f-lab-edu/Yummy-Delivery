package com.yummy.delivery.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.DateTimeException;
import java.time.LocalDateTime;

@Getter
@Setter
public class User {

    public User(String email, String password, String name, String phone, String address) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;

}
