package com.yummy.delivery.coupon.service;

import com.yummy.delivery.core.domain.Coupon;
import com.yummy.delivery.core.repository.CouponRepository;
import com.yummy.delivery.coupon.dto.CreateCoupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CouponService {

    private final CouponRepository couponRepository;

    @Transactional
    public void createCoupon(CreateCoupon createCoupon) {

        Coupon coupon = Coupon.create(createCoupon);
        couponRepository.save(coupon);
    }



}
