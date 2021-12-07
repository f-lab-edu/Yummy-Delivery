package com.yummy.delivery.controller;

import com.yummy.delivery.domain.User;
import com.yummy.delivery.repository.UserRepository;
import com.yummy.delivery.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/user")
    public void signUp(User user) {
        userService.signUp(user);
    }


}
