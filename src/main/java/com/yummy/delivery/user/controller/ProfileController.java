package com.yummy.delivery.user.controller;

import com.yummy.delivery.annotation.LoginUser;
import com.yummy.delivery.user.dto.UpdateUserRequest;
import com.yummy.delivery.user.service.UpdateProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProfileController {

    private final UpdateProfileService updateProfileService;

    @LoginUser
    @PatchMapping("/my-profiles")
    public void changeProfile(@RequestBody UpdateUserRequest updateUserRequest) {
        updateProfileService.update(updateUserRequest);
    }
}
