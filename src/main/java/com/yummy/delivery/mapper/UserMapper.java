package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserMapper {

    void insertUser(@Param("email") String email, @Param("password") String password, @Param("name") String name,
                    @Param("phone") String phone, @Param("address") String address, @Param("created_at") LocalDateTime created_at,
                    @Param("updated_at") LocalDateTime updated_at);

    boolean isExistsEmail(String email);

//    Optional<User> findByEmail(String email);

    List<User> findAll();


}


