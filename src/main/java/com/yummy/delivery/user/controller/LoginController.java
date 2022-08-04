package com.yummy.delivery.user.controller;

import com.yummy.delivery.user.service.LoginService;
import com.yummy.delivery.user.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public void login(@Valid @RequestBody LoginRequest loginRequest) {
        loginService.login(loginRequest);
    }

    @GetMapping("/logout")
    public void logout() {
        loginService.logoutUser();
    }
}
