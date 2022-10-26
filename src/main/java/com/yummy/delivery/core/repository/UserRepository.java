package com.yummy.delivery.core.repository;

import com.yummy.delivery.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailEqualsIgnoreCase(String email);

    User findByEmail(String email);

    List<User> findByGradeEquals(User.Grade grade);
}
