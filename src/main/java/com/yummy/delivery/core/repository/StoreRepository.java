package com.yummy.delivery.core.repository;

import com.yummy.delivery.core.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {

    boolean existsByNameAndAddressEqualsIgnoreCase(String name, String address);

}
