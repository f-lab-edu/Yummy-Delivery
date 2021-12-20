package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    void insertUser(User user);

    void deleteUser(@Param("email") String email);

    boolean isExistsEmail(@Param("email") String email);

    List<User> findAll();

    //    Optional<User> findByEmail(String email);

}



/* @Param Annotation 방식 */
//    void insertUser(@Param("email") String email, @Param("password") String password, @Param("name") String name,
//                    @Param("phone") String phone, @Param("address") String address, @Param("created_at") LocalDateTime created_at,
//                    @Param("updated_at") LocalDateTime updated_at);

