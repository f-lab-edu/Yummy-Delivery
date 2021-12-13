package com.yummy.delivery.controller;

import com.yummy.delivery.domain.User;
import com.yummy.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/all")
    public List<User> getUserList() {
        return userService.getUserList();
    }


    @PostMapping("/user")
    public void signUp(User user) {
        userService.signUp(user);
    }

}

/*파라미터 방식*/
//@PostMapping("/user")
//    public void signUp(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
//        userService.signUp(email, password, name, phone, address);
//    }
