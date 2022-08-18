package com.yummy.delivery.core.repository;

import com.yummy.delivery.core.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
