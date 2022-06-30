package com.yummy.delivery.core.repository;


import com.yummy.delivery.core.domain.Store;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
  boolean existsByNameEquals(String name);

  List<Store> findAllByNameEquals(String name);

  // select * From store where address = ? AND category = ?
  List<Store> findAllByAddressEqualsAndCategoryEquals(
      String address, String category
  );

}
