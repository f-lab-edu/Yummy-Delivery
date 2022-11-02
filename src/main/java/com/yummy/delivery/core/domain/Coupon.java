package com.yummy.delivery.core.domain;

import com.yummy.delivery.coupon.dto.CreateCoupon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private BigDecimal discountPrice;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static Coupon create(CreateCoupon createCoupon) {
        Coupon coupon = new Coupon();

        coupon.name = createCoupon.getName();
        coupon.discountPrice = createCoupon.getDiscountPrice();
        coupon.createdAt = LocalDateTime.now();
        coupon.updatedAt = LocalDateTime.now();
        return coupon;
    }

}
