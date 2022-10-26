package com.yummy.delivery.coupon.batch;

import com.yummy.delivery.core.domain.Coupon;
import com.yummy.delivery.core.domain.CouponTicket;
import com.yummy.delivery.core.domain.User;
import com.yummy.delivery.core.repository.CouponTicketJdbcRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class CouponTicketJdbcRepositoryTest {

    @Autowired
    CouponTicketJdbcRepository couponTicketJdbcRepository;

    @Test
    public void testJdbc() {
        Coupon coupon = Coupon.builder()
                .id(1L)
                .build();
        User user = User.builder()
                .id(1L)
                .build();
        List<CouponTicket> couponTicketList = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            CouponTicket couponTicket = CouponTicket.builder()
                            .coupon(coupon)
                            .user(user)
                            .createdAt(LocalDateTime.now())
                            .updatedAt(LocalDateTime.now())
                            .build();

            couponTicketList.add(couponTicket);
        }
        couponTicketJdbcRepository.insertCouponTicket(couponTicketList);
    }
}
