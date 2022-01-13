package com.yummy.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class Seller {

    private Long id;

    private String email;

    private String password;

    private LocalDateTime createdAt;
  
    private LocalDateTime updatedAt;

}