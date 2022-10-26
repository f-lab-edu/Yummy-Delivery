package com.yummy.delivery.core.repository;

import com.yummy.delivery.core.domain.CouponTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CouponTicketRepository extends JpaRepository<CouponTicket, Long> {

    CouponTicket findCouponTicketByIdAndUserIdAndOrderIsNull(Long id, Long userId);

    @Query("select c from CouponTicket c join fetch c.coupon where :userId = c.user.id")
    List<CouponTicket> findCouponTicketFetchJoin(Long userId);

    //select * from coupon_ticket where id = :id and user_id = :id
    CouponTicket findCouponTicketByIdAndUserId(Long id, Long userId);

    //select * from coupon_ticket where id = :id and user_id = :id
    CouponTicket findCouponTicketByIdAndUserIdAndOrderIdIsNotNull(Long id, Long userId);

}
