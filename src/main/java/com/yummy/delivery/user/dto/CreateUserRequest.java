package com.yummy.delivery.user.dto;

import lombok.Data;

@Data
public class CreateUserRequest {
  private String email;
  private String password;
  private String name;
  private String phone;
  private String address;
}