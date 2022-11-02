package com.yummy.delivery.core.repository;

import com.yummy.delivery.core.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {


}
