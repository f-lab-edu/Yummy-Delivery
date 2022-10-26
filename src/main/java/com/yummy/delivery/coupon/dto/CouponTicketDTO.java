package com.yummy.delivery.coupon.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Builder
public class CouponTicketDTO {

    private Long couponId;

    private String name;

    private BigDecimal discountValue;

}
