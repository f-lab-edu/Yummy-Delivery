package com.yummy.delivery.aop;

import com.yummy.delivery.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
@Aspect
@RequiredArgsConstructor
public class UserAspect {

    private final LoginService loginService;

    @Before("@annotation(com.yummy.delivery.annotation.LoginUser)")
    public void validationLogin() {
        Optional.ofNullable(loginService.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));
    }
}
