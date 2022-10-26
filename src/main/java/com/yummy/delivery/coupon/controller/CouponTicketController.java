package com.yummy.delivery.coupon.controller;

import com.yummy.delivery.annotation.LoginUser;
import com.yummy.delivery.core.repository.UserRepository;
import com.yummy.delivery.coupon.dto.CouponTicketDTO;
import com.yummy.delivery.coupon.service.CouponTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/couponTickets")
@RestController
public class CouponTicketController {

    private final CouponTicketService couponticketService;
    private final UserRepository userRepository;

    @LoginUser
    @PostMapping("/create")
    public void addCouponIssue(@RequestBody CouponTicketDTO couponTicketDTO) {
//        couponticketService.createCouponTicket(couponTicketDTO);
    }

    @LoginUser
    @GetMapping("/find")
    public List<CouponTicketDTO> findCoupon() {
        return couponticketService.findCoupon();
    }

}
