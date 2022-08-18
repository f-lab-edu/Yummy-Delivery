package com.yummy.delivery.core.repository;

import com.yummy.delivery.core.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    boolean existsByEmailEqualsIgnoreCase(String email);

    Seller findByEmail(String email);

    void deleteSellerByEmail(String email);
}
