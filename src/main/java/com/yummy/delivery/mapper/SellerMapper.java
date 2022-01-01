package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SellerMapper {

    @Select("SELECT * FROM Seller WHERE email = #{email} AND password = #{password}")
    Seller findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
    
    void insertSeller(Seller seller);

    @Select("SELECT * FROM Seller WHERE email = #{email}")
    Seller findByEmail(@Param("email") String email);

    @Update("UPDATE Seller SET password = #{password}, address = #{address} WHERE email")
    void updateByPasswordAndAddress(Seller seller);
  
}