package com.yummy.delivery.core.repository;


import com.yummy.delivery.core.domain.Menu;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

  List<Menu> findAllByStoreId(Long storeId);
}
