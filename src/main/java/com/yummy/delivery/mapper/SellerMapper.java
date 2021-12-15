package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SellerMapper {

    void insertSeller(Seller seller);

    boolean isExistsEmail(@Param("email") String email);
}
