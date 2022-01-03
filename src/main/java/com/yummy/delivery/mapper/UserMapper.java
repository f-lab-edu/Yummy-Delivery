package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM User WHERE email = #{email} AND password = #{password}")
     User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Select("SELECT * FROM User WHERE email = #{email}")
     User findByEmail(@Param("email") String email);

    @Update("UPDATE User SET password = #{password}, address = #{address} WHERE email")
    void updateByPasswordAndAddress(User user);

}
