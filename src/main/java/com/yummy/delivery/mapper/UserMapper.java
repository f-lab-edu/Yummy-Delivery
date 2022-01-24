package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM User WHERE email = #{email} AND password = #{password}")
     User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Select("SELECT * FROM User WHERE email = #{email}")
     User findByEmail(@Param("email") String email);

    @Update("UPDATE User SET password = #{password}, address = #{address} WHERE email")
    void updateByPasswordAndAddress(User user);

}
    void insertUser(User user);

    void deleteUser(@Param("email") String email);

    boolean isExistsEmail(@Param("email") String email);

    List<User> findAll();

    //    Optional<User> findByEmail(String email);
  
  /* @Param Annotation 방식 */
//    void insertUser(@Param("email") String email, @Param("password") String password, @Param("name") String name,
//                    @Param("phone") String phone, @Param("address") String address, @Param("created_at") LocalDateTime created_at,
//                    @Param("updated_at") LocalDateTime updated_at);

}

