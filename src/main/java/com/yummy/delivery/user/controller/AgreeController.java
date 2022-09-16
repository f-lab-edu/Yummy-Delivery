package com.yummy.delivery.user.controller;

import com.yummy.delivery.annotation.LoginUser;
import com.yummy.delivery.user.dto.AgreeRequest;
import com.yummy.delivery.user.service.AgreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class AgreeController {

    private final AgreeService agreeService;

    @LoginUser
    @PostMapping("/agree")
    public void agree(@Valid @RequestBody AgreeRequest agreeRequest) {
        agreeService.agree(agreeRequest);
    }
}
