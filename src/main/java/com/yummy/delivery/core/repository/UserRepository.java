package com.yummy.delivery.core.repository;

import com.yummy.delivery.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailEqualsIgnoreCase(String email);

}
