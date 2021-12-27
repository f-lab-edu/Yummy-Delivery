package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SellerMapper {

    @Select("SELECT * FROM Seller WHERE email = #{email} AND password = #{password}")
    Seller findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
    
    void insertSeller(Seller seller);

    boolean isExistsEmail(@Param("email") String email);
    
}