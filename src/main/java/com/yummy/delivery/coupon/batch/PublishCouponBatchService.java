package com.yummy.delivery.coupon.batch;

import com.yummy.delivery.core.domain.Coupon;
import com.yummy.delivery.core.domain.CouponTicket;
import com.yummy.delivery.core.domain.User;
import com.yummy.delivery.core.repository.CouponRepository;
import com.yummy.delivery.core.repository.CouponTicketJdbcRepository;
import com.yummy.delivery.core.repository.CouponTicketRepository;
import com.yummy.delivery.core.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class PublishCouponBatchService {
    private final Long COUPON_ID_1000 = 1L;
    private final Long COUPON_ID_2000 = 2L;

    private final UserRepository userRepository;
    private final CouponRepository couponRepository;
    private final CouponTicketJdbcRepository couponTicketJdbcRepository;

    /**
     * 매일 새벽 정각 12시마다 스케줄러를 실행
     */
    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void execute() {
        publishToSilver();
        publishToGold();
        publishToPlatinum();
    }

    /**
     * 실버 등급 - 천원 쿠폰 2장 발급
     */
    private void publishToSilver() {
        List<User> targets = userRepository.findByGradeEquals(User.Grade.SILVER);
        Coupon oneThousandWon = couponRepository.findById(COUPON_ID_1000).get();
        List<CouponTicket> couponTickets = new ArrayList<>();

        for(User user : targets) {
            CouponTicket ticket1 = CouponTicket.builder()
                    .user(user)
                    .coupon(oneThousandWon)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            CouponTicket ticket2 = CouponTicket.builder()
                    .user(user)
                    .coupon(oneThousandWon)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            couponTickets.add(ticket1);
            couponTickets.add(ticket2);
        }

        couponTicketJdbcRepository.insertCouponTicket(couponTickets);
    }

    /**
     * 골드 등급 - 천원 쿠폰 1장, 이천원 쿠폰 2장 발급
     */
    private void publishToGold() {
        List<User> targets = userRepository.findByGradeEquals(User.Grade.GOLD);
        Coupon oneThousandWon = couponRepository.findById(COUPON_ID_1000).get();
        Coupon twoThousandWon = couponRepository.findById(COUPON_ID_2000).get();
        List<CouponTicket> couponTickets = new ArrayList<>();

        for(User user : targets) {
            CouponTicket ticket1 = CouponTicket.builder()
                    .user(user)
                    .coupon(oneThousandWon)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            CouponTicket ticket2 = CouponTicket.builder()
                    .user(user)
                    .coupon(twoThousandWon)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            CouponTicket ticket3 = CouponTicket.builder()
                    .user(user)
                    .coupon(twoThousandWon)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            couponTickets.add(ticket1);
            couponTickets.add(ticket2);
            couponTickets.add(ticket3);
        }

        couponTicketJdbcRepository.insertCouponTicket(couponTickets);
    }

    /**
     * 플래티넘 등급 - 2천원 쿠폰 3장 발급
     */
    private void publishToPlatinum() {
        List<User> targets = userRepository.findByGradeEquals(User.Grade.PLATINUM);
        Coupon twoThousandWon = couponRepository.findById(COUPON_ID_2000).get();
        List<CouponTicket> couponTickets = new ArrayList<>();

        for(User user : targets) {
            CouponTicket ticket1 = CouponTicket.builder()
                    .user(user)
                    .coupon(twoThousandWon)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            CouponTicket ticket2 = CouponTicket.builder()
                    .user(user)
                    .coupon(twoThousandWon)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            CouponTicket ticket3 = CouponTicket.builder()
                    .user(user)
                    .coupon(twoThousandWon)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            couponTickets.add(ticket1);
            couponTickets.add(ticket2);
            couponTickets.add(ticket3);
        }

        couponTicketJdbcRepository.insertCouponTicket(couponTickets);
    }
}
