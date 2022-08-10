package com.yummy.delivery.user.controller;

import com.yummy.delivery.annotation.LoginUser;
import com.yummy.delivery.user.dto.UpdateUserRequest;
import com.yummy.delivery.user.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/my-profiles")
@RestController
public class ProfileController {

    private final ProfileService profileService;

    @LoginUser
    @PatchMapping("/update")
    public void changeProfile(@RequestBody UpdateUserRequest updateUserRequest) {
        profileService.update(updateUserRequest);
    }

    @DeleteMapping("/withdrawal") //세션에 값이 저장되어 있다.
    public void deleteUser() {
        profileService.delete();
    }

}
