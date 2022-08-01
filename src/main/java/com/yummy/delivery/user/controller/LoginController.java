package com.yummy.delivery.user.controller;

import com.yummy.delivery.user.service.LoginService;
import com.yummy.delivery.user.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public void login(@Valid @RequestBody LoginRequest loginRequest) {
        loginService.login(loginRequest);
    }
}
