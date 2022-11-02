package com.yummy.delivery.coupon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateCoupon {

    private String name;

    private BigDecimal discountPrice;

}
