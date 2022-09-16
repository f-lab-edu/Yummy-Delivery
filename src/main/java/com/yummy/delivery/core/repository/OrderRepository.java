package com.yummy.delivery.core.repository;

import com.yummy.delivery.core.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    long countByUserId(Long userId);

    List<Orders> findByUserId(Long userId);
}
