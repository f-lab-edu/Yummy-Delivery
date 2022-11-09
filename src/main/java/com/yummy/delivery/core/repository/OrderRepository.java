package com.yummy.delivery.core.repository;

import com.yummy.delivery.core.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Orders, Long> {

    Long countByUserIdAndOrderStatus(Long userId, Orders.OrderStatus status);
}
