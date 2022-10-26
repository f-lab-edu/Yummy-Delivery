package com.yummy.delivery.core.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CouponTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Orders order;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public void applyTicket(Orders order) {
        this.order = order;
    }

    public void cancelTicket(Orders order) {
        this.order = null;
    }

}
