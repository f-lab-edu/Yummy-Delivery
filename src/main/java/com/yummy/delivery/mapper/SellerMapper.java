package com.yummy.delivery.mapper;

import com.yummy.delivery.domailn.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SellerMapper {

    @Select("SELECT * FROM Seller WHERE email = #{email} AND password = #{password}")
    Seller findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Update("UPDATE Seller SET password = #{password}, address = #{address} WHERE email")
    void updateByPasswordAndAddress(Seller seller);

}