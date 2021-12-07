package com.yummy.delivery.controller;

import com.yummy.delivery.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserDTO userDTO, HttpSession httpSession) {
        return ResponseEntity.ok().build();
    }
}