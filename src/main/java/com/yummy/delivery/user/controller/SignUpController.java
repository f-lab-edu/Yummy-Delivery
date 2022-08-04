package com.yummy.delivery.user.controller;

import com.yummy.delivery.user.dto.CreateUserRequest;
import com.yummy.delivery.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class SignUpController {

    private final SignUpService signUpService;

    @PostMapping("/users")
    public void signUp(@Valid @RequestBody CreateUserRequest createUserRequest) {
        signUpService.signUp(createUserRequest);
  }
}
