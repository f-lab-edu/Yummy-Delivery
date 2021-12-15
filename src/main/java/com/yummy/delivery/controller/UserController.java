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


    @GetMapping("/user/all")
    public List<User> getUserList() {
        return userService.getUserList();
    }

    /* 아이디(이메일) 중복확인 */
    @GetMapping("user/signup/{email}")
    public void checkSameEmail(@RequestParam("email") String email){
        userService.checkSameEmail(email);
    }

    /* 회원가입 */
    @PostMapping("/user/signup")
    public void signUp(User user) {
        userService.checkNullData(user);    //  회원정보를 모두 기입했는지 확인하는 메서드
        userService.checkPasswordLength(user);  //  비밀번호를 8자리 이상 기입했는지 확인하는 메서드
        userService.signUp(user);
    }



}

/* @Param Annotation 방식 */
//@PostMapping("/user")
//    public void signUp(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
//        userService.signUp(email, password, name, phone, address);
//    }
