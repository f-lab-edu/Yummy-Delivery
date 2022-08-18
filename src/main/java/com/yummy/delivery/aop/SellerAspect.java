package com.yummy.delivery.aop;

import com.yummy.delivery.seller.service.LoginSellerService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@RequiredArgsConstructor
@Configuration
@Aspect
public class SellerAspect {

    private final LoginSellerService loginSeller;

    @Before("@annotation(com.yummy.delivery.annotation.LoginSeller)")
    public void validationLogin() {
        Optional.ofNullable(loginSeller.getSellerBySession())
                .orElseThrow(() -> new IllegalArgumentException("판매자를 찾을 수 없습니다."));
    }
}
