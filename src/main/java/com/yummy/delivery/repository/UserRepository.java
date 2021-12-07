package com.yummy.delivery.repository;

import com.yummy.delivery.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {

    void insertUser(User user);

    boolean isExistsEmail(String email);

    Optional<User> findByEmail(String email);

//    List<User> findAll();





}
