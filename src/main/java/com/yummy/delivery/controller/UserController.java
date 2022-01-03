package com.yummy.delivery.controller;

import com.yummy.delivery.dto.UserDTO;
import com.yummy.delivery.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.yummy.delivery.httpStatus.httpComponent.RESPONSE_ENTITY_OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserDTO userDTO) {
        userService.login(userDTO);
        return RESPONSE_ENTITY_OK;
    }

    @GetMapping("/logout")
    public ResponseEntity<Void> logout() {
        userService.logout();
        return RESPONSE_ENTITY_OK;
    }

    @PutMapping("/mypage")
    public ResponseEntity<Void> updateSeller(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
        return RESPONSE_ENTITY_OK;
    }

}