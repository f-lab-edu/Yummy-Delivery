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
    public void signUp(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        userService.signUp(email, password, name, phone, address);
    }


}



//@RestController
//public class UserProfileController {
//
//    @Autowired
//    private UserProfileMapper mapper;
//
//    public UserProfileController(UserProfileMapper mapper) {
//        this.mapper = mapper;
//    }
//
//    @GetMapping("/user/{id}")
//    public UserProfile getUserProfile(@PathVariable("id") String id) {
//        return mapper.getUserProfile(id);
//    }
//
//    @GetMapping("/user/all")
//    public List<UserProfile> getUserProfileList() {
//        return mapper.getUserProfileList();
//    }
//
//    @PutMapping("/user/{id}")
//    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
//        mapper.insertUserProfile(id, name, phone, address);
//    }
//
//    @PostMapping("/user/{id}")
//    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
//        mapper.updateUserProfile(id, name, phone, address);
//    }
//
//    @DeleteMapping("/user/{id}")
//    public void deleteUserProfile(@PathVariable("id") String id) {
//        mapper.deleteUserProfile(id);
//    }
//}
