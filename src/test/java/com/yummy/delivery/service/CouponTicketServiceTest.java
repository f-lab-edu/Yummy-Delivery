package com.yummy.delivery.service;

import com.yummy.delivery.coupon.service.CouponTicketService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class CouponTicketServiceTest {
    @Autowired
    CouponTicketService couponTicketService;

    @Test
    public void test_createTicket() {
        couponTicketService.createCouponTicket(51L, 1L, 2L);
    }

}
