package com.yummy.delivery.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class User {

    private Long id;

    private String email;

    private String password;

    private String name;

    private String phone;

    private String address;

    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;

}