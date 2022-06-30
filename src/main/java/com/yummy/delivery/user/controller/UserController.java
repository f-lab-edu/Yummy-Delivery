package com.yummy.delivery.user.controller;

import com.yummy.delivery.user.UserService;
import com.yummy.delivery.user.dto.CreateUserRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class UserController {
  private final UserService userService;

  @PostMapping("/users")
  public void signUp(@RequestBody CreateUserRequest createUserRequest) {
    userService.signUp(createUserRequest);
  }
}
