package com.yummy.delivery.coupon.service;

import com.yummy.delivery.core.domain.Coupon;
import com.yummy.delivery.core.domain.CouponTicket;
import com.yummy.delivery.core.domain.User;
import com.yummy.delivery.core.repository.CouponTicketRepository;
import com.yummy.delivery.coupon.dto.CouponTicketDTO;
import com.yummy.delivery.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CouponTicketService {

    private final CouponTicketRepository couponTicketRepository;
    private final LoginService loginService;

    public List<CouponTicketDTO> findCoupon() {
        User user = loginService.getLoggedInUserFromDatabase();
        List<CouponTicket> couponLists = couponTicketRepository.findCouponTicketFetchJoin(user.getId());
        List<CouponTicketDTO> tickets = new ArrayList<>();

        for (CouponTicket couponTicket : couponLists) {
            CouponTicketDTO couponTicketDTO = CouponTicketDTO.builder()
                    .couponId(couponTicket.getCoupon().getId())
                    .name(couponTicket.getCoupon().getName())
                    .discountValue(couponTicket.getCoupon().getDiscountPrice())
                    .build();

            tickets.add(couponTicketDTO);
        }

        return tickets;
    }

    @Transactional
    public void createCouponTicket(Long userId, Long couponId, Long count) {
        for (int i = 0; i < count; i++) {
            CouponTicket couponTicket = CouponTicket.builder()
                    .coupon(Coupon.builder()
                            .id(couponId)
                            .build())
                    .user(User.builder()
                            .id(userId)
                            .build())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            couponTicketRepository.save(couponTicket);
        }
    }
}
