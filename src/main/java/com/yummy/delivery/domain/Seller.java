package com.yummy.delivery.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class Seller {

    private Long id;

    private String email;

    private String password;

    private LocalDateTime createdAt;
  
    private LocalDateTime updatedAt;

}