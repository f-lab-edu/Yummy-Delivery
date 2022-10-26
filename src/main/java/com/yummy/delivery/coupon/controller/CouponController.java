package com.yummy.delivery.coupon.controller;

import com.yummy.delivery.coupon.dto.CreateCoupon;
import com.yummy.delivery.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/coupons")
@RestController
public class CouponController {

    private final CouponService couponService;

    @PostMapping("/create")
    public void createCoupon(@RequestBody CreateCoupon createCoupon) {
        couponService.createCoupon(createCoupon);
    }


}
