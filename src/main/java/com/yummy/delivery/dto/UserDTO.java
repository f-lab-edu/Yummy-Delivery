package com.yummy.delivery.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserDTO {

    private String email;

    private String password;

    private String name;

    private String phone;

    private String address;

}