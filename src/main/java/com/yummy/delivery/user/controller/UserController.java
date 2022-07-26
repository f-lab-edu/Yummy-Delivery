package com.yummy.delivery.user.controller;

import com.yummy.delivery.service.UserService;
import com.yummy.delivery.user.dto.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public void signUp(@Valid @RequestBody CreateUserRequest createUserRequest) {
        userService.signUp(createUserRequest);
    }

}
